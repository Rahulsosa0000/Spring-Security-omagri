package com.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.UserDtls;
import com.security.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    
    
    public List<UserDtls> getAllUsers() {
        return userRepo.findAll();
    }

    // Create or Update User
    public UserDtls createUser(UserDtls userDtls) {
    	//userDtls.setId(0);
        return userRepo.save(userDtls);
    }

    // Get User by ID
    public Optional<UserDtls> getUserById(Integer id) {
        return userRepo.findById(id);
    }

    // Get User by Username
    public Optional<UserDtls> getUserByUsername(String username) {
        return Optional.ofNullable(userRepo.findByusername(username));
    }

    // Delete User
    public boolean deleteUser(Integer id) {
        Optional<UserDtls> user = userRepo.findById(id);
        if (user.isPresent()) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Update User
    public UserDtls updateUser(Integer id, UserDtls updatedUser) {
        if (userRepo.existsById(id)) {
            updatedUser.setId(id);
            return userRepo.save(updatedUser);
        }
        return null;
    }
}