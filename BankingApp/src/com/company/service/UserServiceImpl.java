package com.company.service;


import com.company.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//clasa de serviciu pentru User
public class UserServiceImpl implements UserService {

    List<String> userArray = new ArrayList<>();

    @Override
    public Optional<String> addNewUser(User user) {
        userArray.add(String.valueOf(user));//optional needed by line below
        return userArray.stream().findAny();
    }


    @Override
    public Optional<String> updateUserInfo(User user) {
       // userArray.replaceAll(user);   //does not work, gives error for now
        return userArray.stream().findAny();
    }

}