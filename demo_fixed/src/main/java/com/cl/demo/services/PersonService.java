package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.Person;
import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.entities.UserName;
import com.cl.demo.requestobjects.PersonCreateRequest;
import com.cl.demo.requestobjects.PersonUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class PersonService {

    public static final String PERSON_USERNAME_OR_EMAIL_ALREADY_TAKEN = "Given username or email is already taken";
    public static final String PERSON_SAVED = "Person saved";
    public static final String REQUIRED_FIELDS = "Username, email and phone number are required";

    @Autowired
    private PhoneNumberService phoneNumberService;

    public Map<String, String> addPerson(PersonCreateRequest requestObj) {

        Map<String, String> response = new HashMap<>();
        Person person = new Person();

        if (isBlank(requestObj.getPersonUserName()) || isBlank(requestObj.getPersonEmail())
                || requestObj.getPersonPhoneNumber() == null) {
            response.put("error", REQUIRED_FIELDS);
            return response;
        }

        if (!verifyUserNameAndEmail(requestObj.getPersonUserName(), requestObj.getPersonEmail())) {
            response.put("error", PERSON_USERNAME_OR_EMAIL_ALREADY_TAKEN);
            return response;
        }

        person.setId(UUID.randomUUID());
        person.setIsActive(Boolean.TRUE);
        person.setCreatedDate(new Date());

        UserName userName = new UserName();
        userName.setId(UUID.randomUUID());
        userName.setIsActive(Boolean.TRUE);
        userName.setCreatedDate(new Date());
        userName.setActiveUserName(requestObj.getPersonUserName());

        person.setUserName(userName);
        person.setName(getFullName(requestObj));
        person.setEmail(requestObj.getPersonEmail());
        PhoneNumber phoneNumber = phoneNumberService.addPhoneNumber(
                requestObj.getPersonCountryCode(), requestObj.getPersonPhoneNumber());
        person.setPhoneNumber(phoneNumber);
        Boolean result = DemoApplication.Person_List.add(person);

        if (result) {
            DemoApplication.emails.add(requestObj.getPersonEmail());
            DemoApplication.userNames.add(requestObj.getPersonUserName());
            response.put("response", PERSON_SAVED);
        }
        return response;
    }

    public Person getPersonById(String uuid) {
        for (Person p : DemoApplication.Person_List) {
            if (p.getId().toString().equals(uuid) && Boolean.TRUE.equals(p.getIsActive())) {
                return p;
            }
        }
        return new Person();
    }

    public Person updatePerson(PersonUpdateRequest updateObj) {
        Person person = getPersonById(updateObj.getUuid());
        if (person == null || person.getId() == null || !person.getIsActive()) {
            return person;
        }
        DemoApplication.Person_List.remove(person);

        person.setUserName(getUserNameByCompare(person.getUserName(), updateObj));
        person.setEmail(HelperUtils.compare(person.getEmail(), updateObj.getEmailToUpdate()));
        person.setUpdatedDate(new Date());

        DemoApplication.Person_List.add(person);
        return person;
    }

    public List<Person> getAllPersons() {
        List<Person> resultList = new ArrayList<>();
        for (Person p : DemoApplication.Person_List) {
            if (p.getIsActive()) {
                resultList.add(p);
            }
        }
        return resultList;
    }

    public Boolean verifyUserNameAndEmail(String userName, String email) {
        return !DemoApplication.emails.contains(email) && !DemoApplication.userNames.contains(userName);
    }

    public String getFullName(PersonCreateRequest request) {
        return request.getPersonFirstName() + " " +
                request.getPersonMiddleName() + " " +
                request.getPersonLastName();
    }

    private UserName getUserNameByCompare(UserName currentUserNameObj, PersonUpdateRequest updateRequest) {
        String userNameToUpdate = HelperUtils.compare(currentUserNameObj.getActiveUserName(),
                updateRequest.getUserNameToUpdate());
        if (userNameToUpdate.equals(currentUserNameObj.getActiveUserName())) {
            return currentUserNameObj;
        }
        if (!DemoApplication.userNames.contains(userNameToUpdate)) {

            List<String> userNameHistory = currentUserNameObj.getPrevUserNames();
            if (userNameHistory == null) {
                userNameHistory = new ArrayList<>();
            }
            userNameHistory.add(currentUserNameObj.getActiveUserName());

            currentUserNameObj.setPrevUserNames(userNameHistory);
            DemoApplication.userNames.add(userNameToUpdate);
            currentUserNameObj.setActiveUserName(userNameToUpdate);
        }

        return currentUserNameObj;
    }

    public Boolean deleteById(String uuid) {
        Person person = getPersonById(uuid);
        if (person == null || person.getId() == null || !Boolean.TRUE.equals(person.getIsActive())) {
            return false;
        } else {
            DemoApplication.Person_List.remove(person);
            person.setIsActive(false);
            DemoApplication.Person_List.add(person);
            return true;
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
