package com.mackittipat.bootsecurityuserdetailservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("user")
    public String user() {
        return "User";
    }

}
