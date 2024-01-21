package org.phonepe.repository;

import org.phonepe.models.Action;
import org.phonepe.models.Journey;
import org.phonepe.models.JourneyTemplate;

import java.util.List;
import java.util.Map;

public interface JourneyRepository {

    void saveJourney(JourneyTemplate journeyTemplate);

    Journey fetchJourney(String journeyId);

    void updateJourney(Journey journey);

    void createJourney(Journey journey);

    void createJourneys(List<Journey> journeyList);

    public Map<Action, List<JourneyTemplate>> getOnboardingActionToJourneyTemplateCache();

}
