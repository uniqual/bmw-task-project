package com.bmw.controller;

import com.bmw.dto.payload.UserRequestDto;
import com.bmw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/")
public class Controller {

    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;
    private final UserService userService;

    @Autowired
    public Controller(RestTemplate restTemplate, UserService userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        ResponseEntity<UserRequestDto[]> usersList = restTemplate.getForEntity(ENDPOINT, UserRequestDto[].class);

        if (usersList.getBody() == null) {
            new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

        if (!validateRestEntity(usersList)) {
            new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.saveAll(Arrays.asList(usersList.getBody()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private boolean validateRestEntity(ResponseEntity<UserRequestDto[]> userEntity) {

        if (userEntity.getStatusCode() != (HttpStatus.OK)) {
            return false;
        }

        if (CollectionUtils.isEmpty(userService.getAll())) {
            return userService.getAll().size() == userEntity.getBody().length;
        }
        return true;
    }
}
