package com.example.test.service;

import com.example.test.model.LogMessage;

import java.util.List;

public interface LogMessagesService {

    void saveLogMessagesToDataBase(List<LogMessage> listLogMessages);

    void getFromDataBaseLogMessagesById(List<Integer> listIdLogMessages);

}
