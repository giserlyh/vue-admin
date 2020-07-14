package com.lu.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String name;
    private String email;
    private String phone;
    private String role;
    private Boolean state;
}
