package com.example.expensetracker.controller;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Api(value = "User Controllers")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Returns the user for the given user id", response = User.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user = userService.findUser(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "Adds the user to the database", response = String.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);

        return new ResponseEntity<>("User Added", HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes the user for the given user id", response = String.class)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);

        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }
}
