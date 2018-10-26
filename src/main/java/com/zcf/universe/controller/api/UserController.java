package com.zcf.universe.controller.api;

import com.zcf.universe.entity.User;
import com.zcf.universe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/user")
    public List<User> findList() {
        return userService.findList();
    }

    @PostMapping("/user")
    public boolean addUser(User user) {
        return this.userService.addUser(user);
    }

    @PutMapping("/user")
    public boolean updateUser(User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        return this.userService.deleteUser(id);
    }

}
