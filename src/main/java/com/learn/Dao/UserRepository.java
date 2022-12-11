package com.learn.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
  
	
	//for get email from database-for authenticate
	@Query("select u from User u where u.email = :email")
	public User getusername(@Param("email") String email);
}
