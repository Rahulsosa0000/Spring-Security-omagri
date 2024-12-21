package com.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.UserDtls;

@Repository
public interface UserRepo extends JpaRepository<UserDtls, Integer>{

	UserDtls findByusername(String username);

}
