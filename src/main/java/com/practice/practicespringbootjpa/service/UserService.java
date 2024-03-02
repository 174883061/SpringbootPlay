package com.practice.practicespringbootjpa.service;

import com.practice.practicespringbootjpa.dao.UserRepository;
import com.practice.practicespringbootjpa.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        logger.info("getAllUsers start :" );
        int a = 0;
        try
        {
            if(a == 0)
            {
                logger.warn(" A should not be zero");
            }
            int b = a /10;
        }catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }

        logger.info("getAllUsers end :" );
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        //user.setName(userDetails.getName());
        //user.setGender(userDetails.getGender());
        return userRepository.save(user);
    }
}
