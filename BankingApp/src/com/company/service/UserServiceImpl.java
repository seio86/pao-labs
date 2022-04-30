package com.company.service;


import com.company.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class UserServiceImpl implements UserService {
    private static UserServiceImpl INSTANCE;
    private List<String> userArray;

    private UserServiceImpl() {
        userArray = new ArrayList<>();
    }

    public  UserServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserServiceImpl();
        }
        return INSTANCE;
    }


    @Override
    public Optional<String> addNewUser(User user) {
        userArray.add(String.valueOf(user));//optional needed by line below
        return userArray.stream().findAny();
    }


    @Override
    public Optional<String> updateUserInfo(User user) {
        return userArray.stream().findAny();
    }

}