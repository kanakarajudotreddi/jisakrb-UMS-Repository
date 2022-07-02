package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.modal.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	   User findUserByEmployeeId(@RequestParam String employeeID);

	   User findUserByUserName(@RequestParam String username);
}
