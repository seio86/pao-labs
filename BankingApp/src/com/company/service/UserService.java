package com.company.service;
import com.company.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<String> addNewUser(User user);
    Optional<String> updateUserInfo(User user);
}