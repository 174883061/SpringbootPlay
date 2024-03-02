package com.practice.practicespringbootjpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id //设置ID字段
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长字段
    private Long id;
    private String name;
    private String gender;

}
