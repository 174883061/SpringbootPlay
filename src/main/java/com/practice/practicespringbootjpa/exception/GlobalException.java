package com.practice.practicespringbootjpa.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
这个类定义了一个全局异常处理器，配合使用@ControllerAdvice和@ExceptionHandler
用来捕获全局的异常，并可以设置跳转到相应的错误处理页面

缺点：如果异常种类很多，那么需要定义很多ExceptionHandler，相应的跳转的错误处理页面也会有很多
 */

//@ControllerAdvice
public class GlobalException {
    //单独使用@ExceptionHandler只能捕获当前类出现的异常
    //@ControllerAdvice和@ExceptionHandler配合使用可以捕获全局异常
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView NullPointerExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.toString()); //添加出错信息
        mv.setViewName("nullPointerError"); //设置跳转页面
        return mv;
    }

    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.toString()); //添加出错信息
        mv.setViewName("arithmeticError"); //设置跳转页面
        return mv;
    }
}
