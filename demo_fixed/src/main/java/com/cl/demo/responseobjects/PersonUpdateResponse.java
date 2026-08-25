package com.cl.demo.responseobjects;

import com.cl.demo.entities.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonUpdateResponse {

    private String personId;
    private String userName;
    private String email;


    public static PersonUpdateResponse convert(Person person) {
        PersonUpdateResponse response = new PersonUpdateResponse();
        if (person == null || person.getId() == null) {
            return response;
        }
        response.setPersonId(person.getId().toString());
        response.setEmail(person.getEmail());
        if (person.getUserName() != null) {
            response.setUserName(person.getUserName().getActiveUserName());
        }
        return response;
    }

    public static List<PersonUpdateResponse> convert(List<Person> personList) {
        List<PersonUpdateResponse> responseList = new ArrayList<>();
        for (Person p : personList) {
            responseList.add(convert(p));
        }
        return responseList;
    }
}
