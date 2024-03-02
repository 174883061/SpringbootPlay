package com.practice.practicespringbootjpa.controller;

import com.practice.practicespringbootjpa.model.Course;
import com.practice.practicespringbootjpa.model.UserCourseVO;
import com.practice.practicespringbootjpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/findallcourses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    //测试用方法，为了抛NullPointerException
    @GetMapping("/showNullPointerError")
    public int showNullPointerException(){
        String str = null;
        return str.length();
    }

    //测试用方法，为了抛ArithmeticException
    @GetMapping("/showArithmeticError")
    public void showArithmeticException(){
        int a = 1/0; //为了抛一个异常，测试自定义错误页面
    }

    //测试用方法，为了抛IndexOutOfBoundsException
    @GetMapping("/showIndexOutOfBoundsError")
    public int showIndexOutOfBoundsException(){
        int[] intArr = {1, 2, 3};
        return intArr[3];
    }



     /*
     在Spring MVC中，@PathVariable注解用于将URL中的模板变量绑定到方法参数上。

     在使用 @GetMapping 或其他映射注解时，花括号 {} 内的名称是路径变量的名称，它是URL模板的一部分。
     在方法参数中使用 @PathVariable 注解来绑定该变量时，有两种选择：

     1. 方法参数名和路径变量名相同，可以省略 @PathVariable 注解中的值：
     在这种情况下，因为方法参数名 userName 与路径变量 {userName} 相同，所以Spring会自动将二者映射。

     2. 如果方法参数名和路径变量名不同，必须在 @PathVariable 注解中指定路径变量的名称：
     @GetMapping("/findStudentAndCourse/{userName}")
     public UserCourseVO getUserAndCourse(@PathVariable("userName") String someOtherName) {
        ...
    }
     在这里，URL路径中的 {userName} 将映射到方法参数 someOtherName。
    */

     @GetMapping("/findStudentAndCourse/{userName}")
    public UserCourseVO getUserAndCourse(@PathVariable String userName){
        return courseService.getUserAndCourse(userName);
    }


}
