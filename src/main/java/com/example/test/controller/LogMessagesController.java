package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogMessagesController {

    @RequestMapping(path = "/log-messages", method = RequestMethod.GET)
    public String logMessagesPage(Model model) {
        return "log-messages";
    }
}
