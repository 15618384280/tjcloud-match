package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.Instructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Created with IDEA
 *
 * @author: WenShun
 * @Date: 2021/04/29
 * @Description:
 */

public class InstructorVo extends Instructor{

    private  Integer guideDirection;//指导员方向

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

    private  Integer instructorLevel;//指导员等级
    private  String issuingUnit;//发证单位编号



}
