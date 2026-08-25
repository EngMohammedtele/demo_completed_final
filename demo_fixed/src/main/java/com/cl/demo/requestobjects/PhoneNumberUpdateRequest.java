package com.cl.demo.requestobjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumberUpdateRequest {
    private String uuid;
    private String countryCodeToUpdate;
    private Long phoneNumberToUpdate;
}
