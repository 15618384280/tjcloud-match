package com.tjcloud.match.utils;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.enums.ExcelType;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.utils.Tuple;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ExcelUtils {
    //所传的数据为俩个list。分为 表头turpList 和 数据voList。list的数据组装格式需按照底部main函数的示例
    // 表头的英文字段需对应VO里的变量名,例：表头Turple<String, String> t = new Turple<String, String>("matchName", "赛事名称");   matchName对应matchVO里的变量 matchName
    public static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
    public static final int SHEET_MAX_CNT = 20000; //每个sheet最多20000条数据

    public static void excelExport(List<Map<String,Object>> list, List<Tuple<String, String>> relation, String name, HttpServletResponse response) throws Exception {
        if (list == null || list.size() == 0 || relation == null || relation.size() == 0) {
            //throw Exception;
        }
        String codedFileName = null;
        response.setContentType("application/vnd.ms-excel");
        codedFileName = java.net.URLEncoder.encode(name, "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");//告诉浏览器已下载的形式打开文件

        OutputStream fileOut = null;

        logger.info("excel导出开始--------------------");
        HSSFWorkbook wb = createExcel(list, relation);
        try {
            //	fileOut = new FileOutputStream("E:\\matchExport.xls");
            fileOut = response.getOutputStream();
            wb.write(fileOut);
            logger.info("excel导出结束--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.flush();
                    fileOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param list
     * @param relation ("name", "姓名");
     * @return
     * @throws Exception
     */
    public static HSSFWorkbook createExcel(List<Map<String,Object>> list, List<Tuple<String, String>> relation) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//设置cell的格式

        //获取需要多少sheet
        int sheetNum = new BigDecimal(list.size()).divide(new BigDecimal(SHEET_MAX_CNT + ""), BigDecimal.ROUND_CEILING).intValue();
        logger.info("总共有sheet:" + sheetNum);
        for (int s = 0; s < sheetNum; s++) {
            HSSFSheet sheet = wb.createSheet();
            sheet.setDefaultColumnWidth(12);

            HSSFRow rowHead = sheet.createRow(0); // 标题
            for (int i = 0; i < relation.size(); i++) {
                HSSFCell cell = rowHead.createCell(i);
                cell.setCellValue(relation.get(i).value + "");
            }

            for (int ro = 0; ro < list.size(); ro++) {//ro层循环决定有多少行
                HSSFRow row = sheet.createRow(ro + 1);
                Map<String, Object> jsonObject = list.get(s * SHEET_MAX_CNT + ro);

                for (int j = 0; j < relation.size(); j++) { // 多少列
                    HSSFCell cell = row.createCell(j);
                    String key = relation.get(j).key;
                    cell.setCellValue(null == jsonObject.get(key) ? "" : jsonObject.get(key).toString());
                }
            }
        }
        return wb;
    }

    /**
     * 解析relation和excel文件第一行标题的交集
     *
     * @param file
     * @param limitRowCount
     * @param relation      ("name", "姓名"); Integer表示状态，(0-不显示,1-显示,2-显示且必填)
     * @return
     * @throws Exception
     */
    public static Tuple<List<JSONObject>, List<String>> resolveExcel(MultipartFile file, int limitRowCount, Map<Tuple<String, String>, Integer> relation) throws Exception {
        ExcelType excelType;
        if (file.getOriginalFilename().endsWith(".xls")) {
            excelType = ExcelType.EXCEL_XLS;
        } else if (file.getOriginalFilename().endsWith(".xlsx")) {
            excelType = ExcelType.EXCEL_XLSX;
        } else {
            throw new BusinessException(MatchMessageLocale.MATCH_IS_ERROR);
        }
        InputStream fileIn = file.getInputStream();
        return resolveExcel(fileIn, limitRowCount, relation, excelType);
    }

    /**
     * 解析relation和excel文件第一行标题的交集
     *
     * @param fileIn
     * @param limitRowCount excel限制的行数，大于0则参数有效，否则不限制
     * @param relation      ("name", "姓名"); Integer表示是否必须，2为必填，(0-不显示,1-显示,2-显示且必填)  @com.tjcloud.match.base.entity.SubjectSignField
     * @param excelType     excel类型 EXCEL_XLS or EXCEL_XLSX
     * @return
     * @throws Exception
     */
	public static Tuple<List<JSONObject>, List<String>> resolveExcel(InputStream fileIn, int limitRowCount, Map<Tuple<String, String>, Integer> relation, ExcelType excelType) throws Exception {

        // 根据指定的文件输入流导入Excel从而产生Workbook对象
        Workbook workbook;
        if (excelType == ExcelType.EXCEL_XLS) {
            workbook = new HSSFWorkbook(fileIn);
        } else {
            workbook = new XSSFWorkbook(fileIn);
        }
        Sheet sheet = workbook.getSheetAt(0);
        ValidateUtils.notNull(sheet, MatchMessageLocale.EXCEL_MODEL_IS_ERROR);

        Row row = sheet.getRow(0);
        // 解析第一行标题
        HashMap<String, Integer> titles = new HashMap<>();
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            String cellValue = row.getCell(i).getStringCellValue();
            if (StringUtils.isEmpty(cellValue)) continue;
            titles.put(cellValue, i);
        }

        List<String> errorList = new ArrayList<>();
        Map<Tuple<String, Integer>, Boolean> indexMap = new HashMap<>();
        relation.forEach(new BiConsumer<Tuple<String, String>, Integer>() {
            @Override
            public void accept(Tuple<String, String> tuple, Integer integer) {
                Integer index = titles.get(tuple.value);
                if (integer == 2 && index == null) {
                    errorList.add("Excel缺少[" + tuple.value + "]列");
                } else if (index != null) {
                    indexMap.put(new Tuple<>(tuple.key, index), integer == 2);
                }
            }
        });

        ValidateUtils.isTrue(indexMap.size() > 0, MatchMessageLocale.EXCEL_MODEL_IS_ERROR); // 没有有效的列

        List<JSONObject> resolvingData = new ArrayList<>();
        int count = sheet.getPhysicalNumberOfRows();
        if (limitRowCount > 0 && count > limitRowCount) count = limitRowCount;
        for (int i = 1; i <= count; i++) {
            Row row1 = sheet.getRow(i);
            if (row1 == null) continue;

            JSONObject jsonObject = new JSONObject();

            for (Map.Entry<Tuple<String, Integer>, Boolean> entry : indexMap.entrySet()) {

                String key = entry.getKey().key;
                Integer column = entry.getKey().value;
                Cell cell = row1.getCell(column);
                Object cellFormatValue = getCellFormatValue(cell);
                if (entry.getValue() && ObjectUtils.isEmpty(cellFormatValue)) {
                    errorList.add("第[" + i + "]行[" + (column + 1) + "]列数据缺失");
                } else {
                    jsonObject.put(key, cellFormatValue);
                }
            }
            resolvingData.add(jsonObject);
        }
        return new Tuple<>(resolvingData, errorList);
    }

    private static Object getCellFormatValue(Cell cell) {
        Object cellValue = "";
        if (cell == null) return cellValue;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
            case Cell.CELL_TYPE_FORMULA: {
                if (DateUtil.isCellDateFormatted(cell)) { // Date
//                    cellValue = cell.getDateCellValue().toLocaleString(); // 2017-1-1 0:00:00
                    cellValue = cell.getDateCellValue(); // 时间戳
                } else {// 纯数字转字符串
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cellValue = cell.getStringCellValue();
                }
                break;
            }
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getRichStringCellValue().getString();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }
}
