package com.iunis.adventclub.controller;

import com.iunis.adventclub.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class DashboardController {

    @GetMapping({"/","/login"})
    public String login(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardAdmin(Model model){
        return "index";
    }
}
