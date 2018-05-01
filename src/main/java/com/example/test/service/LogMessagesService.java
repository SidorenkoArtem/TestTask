package com.example.test.service;

import org.jooq.generated.tables.records.LogRecord;
import java.util.List;

public interface LogMessagesService {

    boolean saveLogMessagesToDataBase(List<LogRecord> listLogMessages);

    void getFromDataBaseLogMessagesById(List<Integer> listIdLogMessages);

}
