package com.cl.demo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserName extends BaseClass {
    private String activeUserName;
    private List<String> prevUserNames;
}
