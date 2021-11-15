package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.InstructorSignTask;
import com.tjcloud.tenant.base.entity.InstructorSignTaskDirection;
import com.tjcloud.tenant.base.entity.InstructorSignTaskLevel;

import java.util.ArrayList;
import java.util.List;

public class InstructorSignTaskVo extends InstructorSignTask {

    {
        directions = new ArrayList<>();
        levels = new ArrayList<>();
    }

    private List<InstructorSignTaskDirection> directions;

    private List<InstructorSignTaskLevel> levels;

    private String typeName;

    private Boolean received;

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public List<InstructorSignTaskDirection> getDirections() {
        return directions;
    }

    public void setDirections(List<InstructorSignTaskDirection> directions) {
        this.directions = directions;
    }

    public List<InstructorSignTaskLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<InstructorSignTaskLevel> levels) {
        this.levels = levels;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
