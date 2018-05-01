package com.example.test.service;

import com.example.test.model.LogMessage;
import org.jooq.generated.tables.records.LogRecord;
import java.util.List;

public interface LogMessagesService {

    boolean saveLogMessagesToDataBase(List<LogRecord> listLogMessages);

    List<LogMessage> getFromDataBaseLogMessagesById(List<Integer> listIdLogMessages);

}
