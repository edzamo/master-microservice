package com.edzamo.rest.webservice.restfullwebservice.application.service;


import com.edzamo.rest.webservice.restfullwebservice.domain.model.User;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private static final List<User> users;

  static {
    users = List.of(new User(1, "Add", LocalDate.now().minusYears(30)),
        new User(2, "Eve", LocalDate.now().minusYears(25)),
        new User(1, "Jim", LocalDate.now().minusYears(20)));
  }


  public List<User> findAll() {
    return users;
  }

  public User findOne(int id) {
    return users
        .stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException(String.format("User with id , %s",id)));
  }
}
