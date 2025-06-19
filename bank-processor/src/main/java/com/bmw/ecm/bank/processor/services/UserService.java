package com.bmw.ecm.bank.processor.services;

import com.bmw.ecm.bank.processor.entities.UsersEntity;
import com.bmw.ecm.bank.processor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


   public List<UsersEntity> getUsers(){
        return userRepository.findAll();
    }

    public UsersEntity saveUser(UsersEntity user) {

       //create a builder util, which uses modelMapper to transform from UsersEntity to UserDto and versa versa
        return userRepository.save(user);
    }
}
