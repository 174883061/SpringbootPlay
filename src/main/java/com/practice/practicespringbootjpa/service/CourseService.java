package com.practice.practicespringbootjpa.service;

import com.practice.practicespringbootjpa.dao.CourseRepository;
import com.practice.practicespringbootjpa.model.Course;
import com.practice.practicespringbootjpa.model.UserCourseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private static final Logger logger = LogManager.getLogger(CourseService.class);
    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getAllCourses(){
        logger.info("getAllCourses");
        return courseRepository.findAll();
    }

    public void addUser(Course course){
        logger.info("addUser");
        courseRepository.save(course);
    }

    public UserCourseVO getUserAndCourse(String userName) {


        return courseRepository.getUserAndCourse(userName);
    }
}
