package com.example.test.rest;

import com.example.test.model.LogMessage;
import com.example.test.service.LogMessagesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/log-messages")
public class LogMessagesRestController {

    private LogMessagesService logMessagesService;

    public LogMessagesRestController(final LogMessagesService logMessagesService) {
        this.logMessagesService = logMessagesService;
    }

    @RequestMapping(value = "/get-log-messages", method = RequestMethod.POST)
    public void getLogMessages() {
        List<Integer> listIdOfLogMessages = new ArrayList<>();
        logMessagesService.getFromDataBaseLogMessagesById(listIdOfLogMessages);
        //todo
    }

    @RequestMapping(value = "/set-log-messages", method = RequestMethod.POST)
    public void setLogMessages(@RequestParam(name = "tag") String tag, @RequestParam(name = "message") String message,
                               @RequestParam(name = "ex") String ex) {
        List<LogMessage> listLogMessages = new ArrayList<>();
        logMessagesService.saveLogMessagesToDataBase(listLogMessages);
        //todo
    }

}
