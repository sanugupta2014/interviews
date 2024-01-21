package org.phonepe.service.impl;


import org.phonepe.enums.JourneyState;
import org.phonepe.exceptions.InvalidJourneyException;
import org.phonepe.models.Action;
import org.phonepe.models.Journey;
import org.phonepe.models.JourneyTemplate;
import org.phonepe.repository.JourneyRepository;
import org.phonepe.repository.impl.JourneyRepositoryImpl;
import org.phonepe.service.JourneyService;

import java.util.List;
import java.util.Map;

public class JourneyServiceImpl implements JourneyService {

    private final JourneyRepository journeyRepository;

    public JourneyServiceImpl() {
        this.journeyRepository = new JourneyRepositoryImpl();
    }

    @Override
    public void createJourneyTemplate(JourneyTemplate journeyTemplate) {

        journeyRepository.saveJourney(journeyTemplate);
    }

    @Override
    public void createJourney(Journey journey) {
        journeyRepository.createJourney(journey);
    }

    @Override
    public void createJourneys(List<Journey> journeyList) {
         journeyRepository.createJourneys(journeyList);
    }

    @Override
    public void updateJourneys(List<Journey> journeyList) {
        for (Journey journey : journeyList) {
            journeyRepository.updateJourney(journey);
        }
    }

    @Override
    public void updateState(String journeyId, JourneyState journeyState) throws InvalidJourneyException {

        Journey journey = journeyRepository.fetchJourney(journeyId);

        if (journey == null) {
            throw new InvalidJourneyException("Invalid Journey Id");
        }

        journey.setState(journeyState);

        journeyRepository.updateJourney(journey);

    }

    @Override
    public Journey getJourney(String journeyId) throws InvalidJourneyException{
        Journey journey = journeyRepository.fetchJourney(journeyId);
        if(journey == null){
            throw new InvalidJourneyException("Invalid Journey Id");
        }
        return journey;
    }

    @Override
    public Map<Action, List<JourneyTemplate>> getOnboardingActionToJourneyTemplateCache() {
        return journeyRepository.getOnboardingActionToJourneyTemplateCache();
    }


}
