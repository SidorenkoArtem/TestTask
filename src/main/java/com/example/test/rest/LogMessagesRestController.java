package com.example.test.rest;

import com.example.test.model.LogMessage;
import com.example.test.service.LogMessagesService;
import org.jooq.generated.tables.records.LogRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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

    @RequestMapping(value = "/get-log-messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogMessage> getLogMessages(@RequestBody Integer[] masAppId) {
        List<Integer> listIdOfLogMessages = new ArrayList<>();
        for (Integer i : masAppId) {
            if (i != null)
                listIdOfLogMessages.add(i);
        }
        return logMessagesService.getFromDataBaseLogMessagesById(listIdOfLogMessages);
    }

    @RequestMapping(path = "/set-log-messages", method = RequestMethod.POST)
    public boolean setLogMessages(@RequestBody LogRecord[] logMessage) {
        List<LogRecord> logMessagesList = Arrays.asList(logMessage);
        return logMessagesService.saveLogMessagesToDataBase(logMessagesList);
    }
}