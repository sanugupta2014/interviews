package org.phonepe.models;


import org.phonepe.enums.StageLevel;

import java.util.List;

public class Stage {
    public StageLevel getLevel() {
        return level;
    }

    public void setLevel(StageLevel level) {
        this.level = level;
    }

    private String name;

    private StageLevel level;

    private int sequence;

    private List<Action> actions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
