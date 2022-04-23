package com.bmw.service;

import com.bmw.dto.payload.UserRequestDto;
import com.bmw.entity.User;

import java.util.List;

public interface UserService {

    void saveAll(List<UserRequestDto> usersList);

    List<User> getAll();
}
