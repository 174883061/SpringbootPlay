package com.practice.practicespringbootjpa.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        if(ex instanceof ArithmeticException){
            mv.setViewName("arithmeticError.html");
        }
        if(ex instanceof IndexOutOfBoundsException){
            mv.setViewName("indexOutOfBoundsError.html");
        }
        if(ex instanceof NullPointerException){
            mv.setViewName("nullPointerError.html");
        }
        mv.addObject("error", ex.toString());
        return mv;
    }
}
