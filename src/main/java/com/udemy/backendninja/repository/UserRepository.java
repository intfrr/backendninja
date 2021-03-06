package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{

    User findByUsername(String username);

}
