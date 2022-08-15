package com.otp_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otp_demo.model.Users;



@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

	Users findByUsername(String username);

} 
