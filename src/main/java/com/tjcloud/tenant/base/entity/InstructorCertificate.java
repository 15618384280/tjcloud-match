package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.tenant.api.enums.GuideDirectionEnums;
import com.tjcloud.tenant.api.enums.InstructorLevelEnums;

import java.util.List;

/**
 * 指导员认证(InstructorCertificate)表实体类
 *
 * @author makejava 2021-02-23 15:03:39
 */
public class InstructorCertificate extends AbstractEntity {
    private static final long serialVersionUID = -14557418590151115L;
    //指导员ID
    private String instructorId;
    //指导方向
    private Integer guideDirection;
    //指导员等级
    private Integer instructorLevel;
    //发证单位 
    private String issuingUnit;
    //发证单位
    private String issuingUnitName;
    //指导方向
    private String guideDirectionName;
    //指导员等级
    private String instructorLevelName;

    //指导员认证图片集合
    List<InstructorCertificateImage> instructorCertificateImages;

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getGuideDirection() {
        return guideDirection;
    }

    public void setGuideDirection(Integer guideDirection) {
        this.guideDirection = guideDirection;
    }

    public Integer getInstructorLevel() {
        return instructorLevel;
    }

    public void setInstructorLevel(Integer instructorLevel) {
        this.instructorLevel = instructorLevel;
    }

    public String getIssuingUnit() {
        return issuingUnit;
    }

    public void setIssuingUnit(String issuingUnit) {
        this.issuingUnit = issuingUnit;
    }

    public String getGuideDirectionName() {
        if (!ObjectUtils.isEmpty(this.guideDirection)) {
            return GuideDirectionEnums.getText(this.guideDirection);
        }
        return "";
    }

    public String getInstructorLevelName() {
        if (!ObjectUtils.isEmpty(this.instructorLevel)) {
            return InstructorLevelEnums.getText(this.instructorLevel);
        }
        return "";
    }

    public List<InstructorCertificateImage> getInstructorCertificateImages() {
        return instructorCertificateImages;
    }

    public void setInstructorCertificateImages(List<InstructorCertificateImage> instructorCertificateImages) {
        this.instructorCertificateImages = instructorCertificateImages;
    }

    public String getIssuingUnitName() {
        return issuingUnitName;
    }

    public void setIssuingUnitName(String issuingUnitName) {
        this.issuingUnitName = issuingUnitName;
    }

}