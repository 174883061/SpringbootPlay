package com.practice.practicespringbootjpa.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;
// @Configuration：这是一个配置类
// 缺点：不能把异常信息带到跳转页面，只是知道出了什么异常该跳转到哪个页面
//@Configuration
public class GlobalSimpleMappingException {
    @Bean
    public SimpleMappingExceptionResolver returnSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.put("java.lang.NullPointerException", "nullPointerError"); //第一个参数表示异常的类型，第二个参数表示对应的跳转页面
        properties.put("java.lang.ArithmeticException", "arithmeticError");
        properties.put("java.lang.IndexOutOfBoundsException", "indexOutOfBoundsError");
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
