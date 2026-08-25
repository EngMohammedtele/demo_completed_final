package com.cl.demo.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumber extends BaseClass {
    private String countryCode;
    private Long phoneNumber;

}
