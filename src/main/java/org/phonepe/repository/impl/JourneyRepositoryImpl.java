package org.phonepe.repository.impl;

import org.phonepe.models.Action;
import org.phonepe.models.Journey;
import org.phonepe.models.JourneyTemplate;
import org.phonepe.models.Stage;
import org.phonepe.repository.JourneyRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JourneyRepositoryImpl implements JourneyRepository {


    private Map<String, JourneyTemplate> journeyTemplateIdToObjectMap;

    private Map<String, Journey> journeyIdToObjectMap;

    private Map<Action, List<JourneyTemplate>> onboardingActionToJourneyTemplatesMap;

    public Map<String, JourneyTemplate> getJourneyTemplateIdToObjectMap() {
        return journeyTemplateIdToObjectMap;
    }

    public void setJourneyTemplateIdToObjectMap(Map<String, JourneyTemplate> journeyTemplateIdToObjectMap) {
        this.journeyTemplateIdToObjectMap = journeyTemplateIdToObjectMap;
    }

    public Map<String, Journey> getJourneyIdToObjectMap() {
        return journeyIdToObjectMap;
    }

    public void setJourneyIdToObjectMap(Map<String, Journey> journeyIdToObjectMap) {
        this.journeyIdToObjectMap = journeyIdToObjectMap;
    }

    public Map<Action, List<JourneyTemplate>> getOnboardingActionToJourneyTemplatesMap() {
        return onboardingActionToJourneyTemplatesMap;
    }

    public void setOnboardingActionToJourneyTemplatesMap(Map<Action, List<JourneyTemplate>> onboardingActionToJourneyTemplatesMap) {
        this.onboardingActionToJourneyTemplatesMap = onboardingActionToJourneyTemplatesMap;
    }

    public JourneyRepositoryImpl() {
        journeyTemplateIdToObjectMap = new HashMap<>();
        onboardingActionToJourneyTemplatesMap = new HashMap<>();
        journeyIdToObjectMap = new HashMap<>();
    }


    @Override
    public void saveJourney(JourneyTemplate journeyTemplate) {
        Map<Action,Stage> actionStageMap = journeyTemplate.getActionToStageMap();
        for(Map.Entry<Action, Stage> entry : actionStageMap.entrySet()){
            if(entry.getValue().getSequence() == 1){
                List<JourneyTemplate> journeyTemplateList = onboardingActionToJourneyTemplatesMap.getOrDefault(entry.getKey(), new ArrayList<>());
                journeyTemplateList.add(journeyTemplate);
                onboardingActionToJourneyTemplatesMap.putIfAbsent(entry.getKey(), journeyTemplateList);
            }
        }
        journeyTemplateIdToObjectMap.put(journeyTemplate.getId(), journeyTemplate);
    }


    @Override
    public Journey fetchJourney(String journeyId) {
        return journeyIdToObjectMap.get(journeyId);
    }

    @Override
    public void updateJourney(Journey journey) {
        journeyIdToObjectMap.put(journey.getId(), journey);
    }

    @Override
    public void createJourney(Journey journey) {
        journeyIdToObjectMap.put(journey.getId(), journey);
    }

    @Override
    public void createJourneys(List<Journey> journeyList) {
          journeyList.forEach(journey -> journeyIdToObjectMap.put(journey.getId(), journey));
    }

    @Override
    public Map<Action, List<JourneyTemplate>> getOnboardingActionToJourneyTemplateCache() {
        return onboardingActionToJourneyTemplatesMap;
    }


}
