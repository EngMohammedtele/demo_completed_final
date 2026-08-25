package com.cl.demo.requestobjects;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonCreateRequest {

    private String personFirstName;
    private String personLastName;
    private String personMiddleName;
    private String personUserName;
    private String personEmail;
    private String personCountryCode;
    private Long personPhoneNumber;
}
