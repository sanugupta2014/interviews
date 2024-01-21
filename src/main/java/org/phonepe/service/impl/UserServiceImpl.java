package org.phonepe.service.impl;


import org.phonepe.DTO.Payload;
import org.phonepe.enums.StageLevel;
import org.phonepe.exceptions.InvalidUserException;
import org.phonepe.models.*;
import org.phonepe.repository.UserRepository;
import org.phonepe.repository.impl.UserRepositoryImpl;
import org.phonepe.service.JourneyService;
import org.phonepe.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JourneyService journeyService;

    public UserServiceImpl() {

        userRepository = new UserRepositoryImpl();
        journeyService = new JourneyServiceImpl();
    }

    @Override
    public boolean isOnboarded(String userId, String journeyId) throws InvalidUserException {
        User user = getUser(userId);
        List<Journey> journeys = user.getJourneys();
        if (journeys != null) {
            for (Journey journey : journeys) {
                if (journey.getId().equals(journeyId)) {
                    return journey.getCurrentStage().getLevel() == StageLevel.FIRST;
                }
            }
        }
        return false;
    }

    @Override
    public void evaluate(String userId, Payload payload) throws InvalidUserException {
        User user = getUser(userId);
        List<Journey> userAllJourneys = user.getJourneys();
        Action action = payload.getAction();
        List<Journey> updatedJourneys = new ArrayList<>();

        for (Journey userJourney : userAllJourneys) {
            JourneyTemplate journeyTemplate = userJourney.getJourneyTemplate();
            Map<Action, Stage> actionToStageMap = journeyTemplate.getActionToStageMap();
            Stage expectedStage = actionToStageMap.get(action);
            if (expectedStage != null &&  expectedStage.getSequence() - userJourney.getCurrentStage().getSequence() ==1) {
                userJourney.setCurrentStage(expectedStage);
                updatedJourneys.add(userJourney);
            }
        }

        Map<Action, List<JourneyTemplate>> onboardingActionToJourneyTemplateCache = journeyService.getOnboardingActionToJourneyTemplateCache();
        List<JourneyTemplate> journeyTemplateList = onboardingActionToJourneyTemplateCache.get(action);
        List<Journey> newJourneys = new ArrayList<>();
        for (JourneyTemplate journeyTemplate : journeyTemplateList) {
            Journey journey = new Journey(journeyTemplate);
            newJourneys.add(journey);
            userAllJourneys.add(journey);
        }
        user.setJourneys(userAllJourneys);
        if(!newJourneys.isEmpty()){
            journeyService.createJourneys(newJourneys);
        }
        if(!updatedJourneys.isEmpty()){
            journeyService.updateJourneys(updatedJourneys);
        }
        userRepository.updateUser(user);

    }

    @Override
    public User getUser(String userId) throws InvalidUserException {
        User user = userRepository.fetchUser(userId);
        if (user == null) {
            throw new InvalidUserException("Invalid User Id");
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public Stage getCurrentStage(String userId, String journeyTemplateId) throws InvalidUserException {
        User user = getUser(userId);
        Stage response = null;
        List<Journey> journeys = user.getJourneys();
        if (journeys != null) {
            for (Journey journey : journeys) {
                if (journey.getJourneyTemplate().getId().equals(journeyTemplateId)) {
                    response = journey.getCurrentStage();
                }
            }
        }
        return response;
    }

}
