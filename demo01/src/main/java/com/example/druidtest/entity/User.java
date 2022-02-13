package com.example.druidtest.entity;

import lombok.Data;

@Data

public class User {

    private Integer id;
    private String name;
    private Integer level;
    private String create_time;
    private Integer delete_flag;
    private String extension;

}
