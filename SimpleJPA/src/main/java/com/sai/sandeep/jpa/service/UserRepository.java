package com.sai.sandeep.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.sandeep.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
