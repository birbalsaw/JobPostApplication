package com.bmrgroup.SpringSecPractice001.repo;

import com.bmrgroup.SpringSecPractice001.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
