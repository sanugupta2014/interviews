package org.phonepe.repository.impl;

import org.phonepe.models.User;
import org.phonepe.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> userIdToObjectMap;


    public UserRepositoryImpl() {
        userIdToObjectMap = new HashMap<>();
    }

    @Override
    public User fetchUser(String userId) {

        return userIdToObjectMap.get(userId);
    }

    @Override
    public void updateUser(User user) {
        userIdToObjectMap.put(user.getId(),user);
    }
}
