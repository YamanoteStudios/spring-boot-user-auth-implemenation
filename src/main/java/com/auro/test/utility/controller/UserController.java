package com.auro.test.utility.controller;

import com.auro.test.utility.dao.UserRepository;
import com.auro.test.utility.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String validateUser(@RequestBody User user) {
      User validUser = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
      return validUser == null? "Not a valid user": "User Validated::"+validUser.getUserName();
    }
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("username") String userName) {
        User user = userRepository.findByUserName(userName);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
