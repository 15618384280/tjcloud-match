package com.tjcloud.match.api.utils;

import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.match.api.message.MatchMessageLocale;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ryan on 2017/3/13.
 */
public class SignRecordFieldUtils {
    private static final String[] basicComment = {"姓名", "性别", "手机号", "证件号码", "参赛号码", "排序"};
    public static final String nameControlKey = convertControlKey(basicComment[0]);
    public static final String sexControlKey = convertControlKey(basicComment[1]);
    public static final String phoneControlKey = convertControlKey(basicComment[2]);
    public static final String cerControlKey = convertControlKey(basicComment[3]);
    public static final String matchNoControlKey = convertControlKey(basicComment[4]);
    public static final String gradeNoControlKey = convertControlKey(basicComment[5]);

    public static final Map<String, String> basicSignFields = new LinkedHashMap<>();

    private static HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();

    static {
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
        basicSignFields.put(nameControlKey, basicComment[0]);
        basicSignFields.put(sexControlKey, basicComment[1]);
        basicSignFields.put(phoneControlKey, basicComment[2]);
        basicSignFields.put(cerControlKey, basicComment[3]);
    }

    public static String convertControlKey(String comment) {
        String controlKey;
        if (StringUtils.isEmpty(controlKey = comment.trim())) {
            throw new BusinessException(MatchMessageLocale.PARAM_IS_ERROR);
        }
        return "sf" + (controlKey.hashCode() & 0x7FFFFFFF);
    }

    // 判断是否是四个基本必填信息
    public static boolean isBasicSignField(String controlKey) {
        return !StringUtils.isEmpty(controlKey) && !StringUtils.isEmpty(basicSignFields.get(controlKey));
    }


    public static enum Type {
        UPPERCASE,              //全部大写
        LOWERCASE,              //全部小写
        FIRSTUPPER              //首字母大写
    }

    public static String toPinYin(String str, String spera, Type type, HanyuPinyinOutputFormat format) throws BadHanyuPinyinOutputFormatCombination {
        if (str == null || str.trim().length() == 0) return "";
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        if (type == Type.UPPERCASE)
            format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        else
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);

        String py = "";
        String temp = "";
        String[] t;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((int) c <= 128)
                py += c;
            else {
                t = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (t == null)
                    py += c;
                else {
                    temp = t[0];
                    if (type == Type.FIRSTUPPER)
                        temp = t[0].toUpperCase().charAt(0) + temp.substring(1);
                    py += temp + (i == str.length() - 1 ? "" : spera);
                }
            }
        }
        return py.trim();
    }

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
    	  System.out.println(convertControlKey(basicComment[5]));
//        String s = toPinYin("aAdfas", "_", Type.FIRSTUPPER, new HanyuPinyinOutputFormat());
//        String s1 = toPinYin("大小sssdf", "_", Type.FIRSTUPPER, new HanyuPinyinOutputFormat());
//        String s2 = toPinYin("消息消息", "", Type.FIRSTUPPER, new HanyuPinyinOutputFormat());
//        String s3 = toPinYin(" 的萨 芬", "_", Type.FIRSTUPPER, new HanyuPinyinOutputFormat());
//        String s4 = toPinYin(" 的 萨芬 ", "_", Type.FIRSTUPPER, new HanyuPinyinOutputFormat());
//        System.out.println(s);
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
    }
}