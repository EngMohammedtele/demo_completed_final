package com.cl.demo.responseobjects;

import com.cl.demo.entities.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonCreateResponse {
    private String personId;
    private String fullName;
    private String userName;
    private String email;
    private String phoneNumber;

    public static PersonCreateResponse convert(Person person) {
        PersonCreateResponse response = new PersonCreateResponse();
        if (person == null || person.getId() == null) {
            return response;
        }
        response.setPersonId(person.getId().toString());
        response.setFullName(person.getName());
        if (person.getUserName() != null) {
            response.setUserName(person.getUserName().getActiveUserName());
        }
        response.setEmail(person.getEmail());
        if (person.getPhoneNumber() != null) {
            response.setPhoneNumber(person.getPhoneNumber().getCountryCode() + " "
                    + person.getPhoneNumber().getPhoneNumber());
        }
        return response;
    }

    public static List<PersonCreateResponse> convert(List<Person> personList) {
        List<PersonCreateResponse> responseList = new ArrayList<>();
        for (Person p : personList) {
            responseList.add(convert(p));
        }
        return responseList;
    }
}


