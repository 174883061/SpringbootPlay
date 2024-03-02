package com.practice.practicespringbootjpa.dao;

import com.practice.practicespringbootjpa.model.Course;
import com.practice.practicespringbootjpa.model.UserCourseVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {
    String sql = "SELECT NEW com.practice.practicespringbootjpa.model.UserCourseVO(c, u) " +
            "FROM Course c, User u " +
            "WHERE u.name = :studentName AND u.name = c.studentName";

    @Query(value = sql)
    UserCourseVO getUserAndCourse(@Param("studentName") String studentName);
}
