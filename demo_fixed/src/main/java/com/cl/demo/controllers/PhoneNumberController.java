package com.cl.demo.controllers;

import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.responseobjects.PhoneNumberCreateResponse;
import com.cl.demo.responseobjects.PhoneNumberUpdateResponse;
import com.cl.demo.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phoneNumber")
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;

    @PostMapping("add")
    public PhoneNumberCreateResponse add(@RequestBody PhoneNumberCreateRequest request) { return PhoneNumberCreateResponse.convert(phoneNumberService.addPhoneNumber(request)); }

    @GetMapping("getById")
    public PhoneNumberCreateResponse getById(@RequestParam String uuid) { return PhoneNumberCreateResponse.convert(phoneNumberService.getPhoneNumberById(uuid)); }

    @GetMapping("getAll")
    public List<PhoneNumberCreateResponse> getAll() { return PhoneNumberCreateResponse.convert(phoneNumberService.getAllPhoneNumbers()); }

