package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhoneNumberService {
    public PhoneNumber addPhoneNumber(PhoneNumberCreateRequest request) {
        if (request == null) return new PhoneNumber();
        return addPhoneNumber(request.getCountryCode(), request.getPhoneNumber());
    }

    public PhoneNumber addPhoneNumber(String countryCode, Long number) {
        if (number == null) return new PhoneNumber();
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(UUID.randomUUID());
        phoneNumber.setIsActive(Boolean.TRUE);
        phoneNumber.setCreatedDate(new Date());
        phoneNumber.setCountryCode(countryCode);
        phoneNumber.setPhoneNumber(number);
        DemoApplication.PhoneNumber_List.add(phoneNumber);
        return phoneNumber;
    }

    public PhoneNumber getPhoneNumberById(String uuid) {
        for (PhoneNumber number : DemoApplication.PhoneNumber_List) {
            if (number.getId().toString().equals(uuid) && Boolean.TRUE.equals(number.getIsActive())) return number;
        }
        return new PhoneNumber();
    }

    public List<PhoneNumber> getAllPhoneNumbers() {
        List<PhoneNumber> result = new ArrayList<>();
        for (PhoneNumber number : DemoApplication.PhoneNumber_List) {
            if (Boolean.TRUE.equals(number.getIsActive())) result.add(number);
        }
        return result;
    }

    public PhoneNumber updatePhoneNumber(PhoneNumberUpdateRequest request) {
        PhoneNumber number = getPhoneNumberById(request.getUuid());
        if (number.getId() == null) return number;
        number.setCountryCode(HelperUtils.compare(number.getCountryCode(), request.getCountryCodeToUpdate()));
        number.setPhoneNumber(HelperUtils.compare(number.getPhoneNumber(), request.getPhoneNumberToUpdate()));
        number.setUpdatedDate(new Date());
        return number;
    }

    public Boolean deleteById(String uuid) {
        PhoneNumber number = getPhoneNumberById(uuid);
        if (number.getId() == null) return false;
        number.setIsActive(false);
        return true;
    }
}
