package com.practice.practicespringbootjpa.dao;

import com.practice.practicespringbootjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
