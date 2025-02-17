package com.edzamo.rest.webservice.restfullwebservice.interfaces.controller;

import com.edzamo.rest.webservice.restfullwebservice.application.service.UserService;
import com.edzamo.rest.webservice.restfullwebservice.interfaces.dto.UserDto;
import com.edzamo.rest.webservice.restfullwebservice.interfaces.mapper.UserMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;
  private final UserMapper mapper;

  @GetMapping(path = "/users")
  public List<UserDto> retrieveAllUsers() {
    return userService
        .findAll()
        .stream()
        .map(mapper::userToUserDto)
        .toList();
  }

  @GetMapping(path = "/users/{id}")
  public UserDto retrieveUser(@PathVariable int id) {
    return mapper.userToUserDto(
        userService
            .findOne(id));
  }

  @PostMapping(path = "/users")
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
   /* return ResponseEntity
        .created(null)
        .build();*/
    return  ResponseEntity
        .status(HttpStatus.CREATED)
        .body(userDto);
  }

}
