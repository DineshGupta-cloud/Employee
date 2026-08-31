package com.RestApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoard {

    @GetMapping("/dashboard")
    public String dashBoardHome(){

        return "This is dashboard Page";
    }
}
