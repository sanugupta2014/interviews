package org.phonepe.models;

import org.phonepe.enums.JourneyState;
import org.phonepe.enums.JourneyType;

import java.util.Date;

public class Journey {


    private String id;

    private String name;

    private Stage currentStage;

    public Stage getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public JourneyTemplate getJourneyTemplate() {
        return journeyTemplate;
    }

    public void setJourneyTemplate(JourneyTemplate journeyTemplate) {
        this.journeyTemplate = journeyTemplate;
    }

    private JourneyTemplate journeyTemplate;

    public Journey(JourneyTemplate template){
        this.journeyTemplate = template;
    }


    private JourneyType type;

    private JourneyState state;

    private Date startDate;

    private Date endDate;


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



    public JourneyState getState() {
        return state;
    }

    public void setState(JourneyState state) {
        this.state = state;
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


}
