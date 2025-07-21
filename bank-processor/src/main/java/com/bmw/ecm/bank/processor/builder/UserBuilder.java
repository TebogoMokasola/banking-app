package com.bmw.ecm.bank.processor.builder;

import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.entities.UsersEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {
    private final ModelMapper modelMapper;

    public UserBuilder(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO convertEntityToDTO(UsersEntity user) {

        modelMapper.typeMap(UsersEntity.class, UserDTO.class)
                .addMappings(mapper -> {mapper.map(UsersEntity::getFirstname, UserDTO::setName);
                    mapper.map(UsersEntity::getLastname, UserDTO::setSurname);
                });
        return modelMapper.map(user, UserDTO.class);
    }
}
