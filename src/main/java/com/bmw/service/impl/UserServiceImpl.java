package com.bmw.service.impl;

import com.bmw.dto.mapper.UserMapper;
import com.bmw.dto.payload.UserRequestDto;
import com.bmw.entity.User;
import com.bmw.repository.UserRepository;
import com.bmw.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveAll(List<UserRequestDto> usersList) {
        LOGGER.info("Saving users to database");

        List<User> users = usersList
                .stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());

        userRepository.saveAll(users);
    }

    public List<User> getAll() {
        return  userRepository.findAll();
    }
}
