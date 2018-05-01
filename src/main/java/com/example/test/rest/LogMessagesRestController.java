package com.example.test.rest;

import com.example.test.service.LogMessagesService;
import org.jooq.generated.tables.records.LogRecord;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping(path = "/set-log-messages", method = RequestMethod.POST)
    public boolean setLogMessages(@RequestBody LogRecord[] logMessage) {
        List<LogRecord> logMessagesList = Arrays.asList(logMessage);
        return logMessagesService.saveLogMessagesToDataBase(logMessagesList);
    }
}