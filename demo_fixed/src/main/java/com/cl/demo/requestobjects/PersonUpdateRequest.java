package com.cl.demo.requestobjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonUpdateRequest {
    private String uuid;
    private String userNameToUpdate;
    private String emailToUpdate;
}
