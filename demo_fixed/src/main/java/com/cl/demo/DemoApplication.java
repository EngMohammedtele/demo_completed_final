package com.cl.demo;

import com.cl.demo.entities.Person;
import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.entities.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    public static List<Person> Person_List = new ArrayList<>();
    public static List<Task> Task_List = new ArrayList<>();
    public static List<PhoneNumber> PhoneNumber_List = new ArrayList<>();
    public static Set<String> userNames = new HashSet<>();
    public static Set<String> emails = new HashSet<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
