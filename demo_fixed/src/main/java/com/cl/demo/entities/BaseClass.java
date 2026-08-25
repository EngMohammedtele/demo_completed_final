package com.cl.demo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseClass {

    private UUID id;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
