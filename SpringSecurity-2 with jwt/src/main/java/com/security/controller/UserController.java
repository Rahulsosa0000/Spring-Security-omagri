package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.UserDtls;
import com.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public UserDtls register(@RequestBody UserDtls user) {
        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody UserDtls user) {

        return userService.verify(user);
    }
 
    
    @GetMapping("/")
    public List<UserDtls> getAllUsers() {
        return userService.getAllUsers();  // Calls the service layer to fetch all users
    }

    
//    @PostMapping("/")
//    public ResponseEntity<UserDtls> createUser(@RequestBody UserDtls userDtls) {
//        UserDtls createdUser = userService.createUser(userDtls);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
    
    @PostMapping("/")
    public ResponseEntity<UserDtls> createUser(@RequestBody UserDtls userDtls) {
        UserDtls createdUser = userService.createUser(userDtls);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDtls> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDtls> updateUser(@PathVariable Integer id, @RequestBody UserDtls userDtls) {
        UserDtls updatedUser = userService.updateUser(id, userDtls);
        return updatedUser != null ? ResponseEntity.ok(updatedUser)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.ok("User deleted successfully")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
