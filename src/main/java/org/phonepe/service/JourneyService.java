package org.phonepe.service;

import org.phonepe.enums.JourneyState;
import org.phonepe.exceptions.InvalidJourneyException;
import org.phonepe.models.Action;
import org.phonepe.models.Journey;
import org.phonepe.models.JourneyTemplate;

import java.util.List;
import java.util.Map;

public interface JourneyService {

    void createJourneyTemplate(JourneyTemplate journeyTemplate);

    void createJourney(Journey journey);

    void createJourneys(List<Journey> journeyList);

    void updateJourneys(List<Journey> journeyList);

    void updateState(String journeyId, JourneyState journeyState) throws InvalidJourneyException;


    Journey getJourney(String journeyId) throws InvalidJourneyException;

    public Map<Action, List<JourneyTemplate>> getOnboardingActionToJourneyTemplateCache();


}
