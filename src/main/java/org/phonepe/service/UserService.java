package org.phonepe.service;

import org.phonepe.DTO.Payload;
import org.phonepe.exceptions.InvalidUserException;
import org.phonepe.models.Stage;
import org.phonepe.models.User;

public interface UserService {

    boolean isOnboarded(String userId, String journeyId) throws InvalidUserException;

    void evaluate(String userId, Payload payload) throws InvalidUserException;

    Stage getCurrentStage(String userId, String journeyTemplateId) throws InvalidUserException;

    User getUser(String userId) throws InvalidUserException;

    void updateUser(User user);
}
