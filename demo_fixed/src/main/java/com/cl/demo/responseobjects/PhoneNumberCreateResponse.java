package com.cl.demo.responseobjects;

import com.cl.demo.entities.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PhoneNumberCreateResponse {
    private String phoneNumberId;
    private String countryCode;
    private Long phoneNumber;

    public static PhoneNumberCreateResponse convert(PhoneNumber number) {
        PhoneNumberCreateResponse response = new PhoneNumberCreateResponse();
        if (number == null || number.getId() == null) return response;
        response.setPhoneNumberId(number.getId().toString());
        response.setCountryCode(number.getCountryCode());
        response.setPhoneNumber(number.getPhoneNumber());
        return response;
    }

    public static List<PhoneNumberCreateResponse> convert(List<PhoneNumber> numbers) {
        List<PhoneNumberCreateResponse> responses = new ArrayList<>();
        for (PhoneNumber number : numbers) responses.add(convert(number));
        return responses;
    }
}
