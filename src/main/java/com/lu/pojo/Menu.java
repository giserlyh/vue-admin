package com.lu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private int id;
    private String authName;
    private String path;
    private List<MenuChildren> menuChildren;

}
