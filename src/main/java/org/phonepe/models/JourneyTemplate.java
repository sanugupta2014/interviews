package org.phonepe.models;



import org.phonepe.enums.JourneyType;


import java.util.Date;
import java.util.List;
import java.util.Map;

public class JourneyTemplate {


    private String id;

    private String name;

    private List<Stage> stages;

    private Map<Action,Stage> actionToStageMap;

    private JourneyType type;

    private Date startDate;

    private Date endDate;

    public List<Stage> getStages() {
        return stages;
    }

    public JourneyType getType() {
        return type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }



    public void setType(JourneyType type) {
        this.type = type;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Action, Stage> getActionToStageMap() {
        return actionToStageMap;
    }

    public void setActionToStage(Map<Action, Stage> actionToStageMap) {
        this.actionToStageMap = actionToStageMap;
    }
}
