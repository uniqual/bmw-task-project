package com.bmw.dto.mapper;

import com.bmw.dto.payload.UserRequestDto;
import com.bmw.entity.User;
import org.modelmapper.ModelMapper;

public final class UserMapper {

    private UserMapper() { }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static User toEntity(UserRequestDto userRequestDto) {
        return modelMapper.map(userRequestDto, User.class);
    }
}
