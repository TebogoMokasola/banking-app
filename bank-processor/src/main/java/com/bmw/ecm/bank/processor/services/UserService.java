package com.bmw.ecm.bank.processor.services;

import com.bmw.ecm.bank.processor.builder.UserBuilder;
import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.entities.UsersEntity;
import com.bmw.ecm.bank.processor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserBuilder userBuilder;

    public UserService(UserRepository userRepository, UserBuilder userBuilder) {
        this.userRepository = userRepository;
        this.userBuilder = userBuilder;
    }

    public Page<UserDTO> getUsers(Specification<UsersEntity> spec, int page, int size) {
       Pageable pageable = PageRequest.of(page, size);
        Page<UsersEntity> usersEntity = userRepository.findAll(spec, pageable);
        return usersEntity.map(userBuilder::convertEntityToDTO);
    }

    public Page<UserDTO> getUsersWithTransactions(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
        Page<UsersEntity> usersEntityPage = userRepository.findDistinctByTransactionsIsNotEmpty(pageable);
        return usersEntityPage.map(userBuilder::convertEntityToDTO);
    }


    public UsersEntity saveUser(UsersEntity user) {
        return userRepository.save(user);
    }

}
