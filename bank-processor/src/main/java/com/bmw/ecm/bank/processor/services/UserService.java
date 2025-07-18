package com.bmw.ecm.bank.processor.services;

import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.entities.UsersEntity;
import com.bmw.ecm.bank.processor.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Page<UserDTO> getUsers(int page, int size) {
       Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable).map(this::convertEntityToDTO);
    }

//    private UserDTO convertEntityToDTO(UsersEntity user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setName(user.getFirstname());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setSurname(user.getLastname());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setId(user.getId());
//        userDTO.setGender(user.getGender());
//        return modelMapper.map(user, UserDTO.class);
//        return userDTO;
//    }
    private UserDTO convertEntityToDTO(UsersEntity user) {
        modelMapper.typeMap(UsersEntity.class, UserDTO.class)
                .addMappings(mapper -> {mapper.map(UsersEntity::getFirstname, UserDTO::setName);
                mapper.map(UsersEntity::getLastname, UserDTO::setSurname);
                });
        return modelMapper.map(user, UserDTO.class);
    }

    public UsersEntity saveUser(UsersEntity user) {

       //create a builder util, which uses modelMapper to transform from UsersEntity to UserDto and versa versa
        return userRepository.save(user);
    }

}
