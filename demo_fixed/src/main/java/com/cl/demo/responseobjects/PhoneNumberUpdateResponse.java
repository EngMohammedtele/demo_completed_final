package com.cl.demo.responseobjects;

import com.cl.demo.entities.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PhoneNumberUpdateResponse {
    private String phoneNumberId;
    private String countryCode;
    private Long phoneNumber;

    public static PhoneNumberUpdateResponse convert(PhoneNumber number) {
        PhoneNumberUpdateResponse response = new PhoneNumberUpdateResponse();
        if (number == null || number.getId() == null) return response;
        response.setPhoneNumberId(number.getId().toString());
        response.setCountryCode(number.getCountryCode());
        response.setPhoneNumber(number.getPhoneNumber());
        return response;
    }

    public static List<PhoneNumberUpdateResponse> convert(List<PhoneNumber> numbers) {
        List<PhoneNumberUpdateResponse> responses = new ArrayList<>();
        for (PhoneNumber number : numbers) responses.add(convert(number));
        return responses;
    }
}
