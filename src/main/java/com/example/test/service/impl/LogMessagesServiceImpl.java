package com.example.test.service.impl;

import com.example.test.bean.Connector;
import com.example.test.service.LogMessagesService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.generated.tables.Log;
import org.jooq.generated.tables.records.LogRecord;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@Service
public class LogMessagesServiceImpl implements LogMessagesService {

    @Autowired
    Connector connector;

    @Override
    public boolean saveLogMessagesToDataBase(List<LogRecord> logMessagesList) {
        try(Connection con = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPass())) {
            DSLContext dsl = DSL.using(con, SQLDialect.POSTGRES);
            for(LogRecord logMessage : logMessagesList) {
                dsl.insertInto(Log.LOG, Log.LOG.ID, Log.LOG.APP_ID, Log.LOG.TAG, Log.LOG.MESSAGE, Log.LOG.EX)
                        .values(7 ,3, logMessage.getTag(), logMessage.getMessage(),
                                logMessage.getEx()).execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void getFromDataBaseLogMessagesById(List<Integer> listIdLogMessages) {
        System.out.println("getLogMessagesFromDataBase");
        //todo
    }
}
