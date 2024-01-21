package org.phonepe.repository;

import org.phonepe.models.User;

public interface UserRepository {

    User fetchUser(String userId);

    void updateUser(User user);

}
