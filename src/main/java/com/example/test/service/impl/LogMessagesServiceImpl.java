package com.example.test.service.impl;

import com.example.test.model.LogMessage;
import com.example.test.service.LogMessagesService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LogMessagesServiceImpl implements LogMessagesService {

    @Override
    public void saveLogMessagesToDataBase(List<LogMessage> listLogMessages) {
        System.out.println("saveToDataBaseLogMessages");
        //todo
    }

    @Override
    public void getFromDataBaseLogMessagesById(List<Integer> listIdLogMessages) {
        System.out.println("getLogMessagesFromDataBase");
        //todo
    }
}
