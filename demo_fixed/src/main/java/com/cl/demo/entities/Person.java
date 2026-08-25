package com.cl.demo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Person extends BaseClass {
    private String name;
    private UserName userName;
    private String email;
    private PhoneNumber phoneNumber;
    private List<Task> tasks;

}
