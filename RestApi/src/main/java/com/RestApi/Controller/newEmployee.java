package com.RestApi.Controller;

import com.RestApi.Model.NewEmployee;
import com.RestApi.Repository.NewEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class newEmployee {

    @Autowired
     private NewEmployeeRepository employeeRepository;

    @GetMapping("/getCount")
    public List<NewEmployee> getCountOfMaleFemale(){

        List<NewEmployee> newEmployee= (List<NewEmployee>) employeeRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy
                        (NewEmployee::getGender, Collectors.counting()));


        System.out.println(newEmployee);
        return  newEmployee;
    }
}
