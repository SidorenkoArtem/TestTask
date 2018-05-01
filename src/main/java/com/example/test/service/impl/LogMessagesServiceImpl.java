package com.example.test.service.impl;

import com.example.test.bean.Connector;
import com.example.test.model.LogMessage;
import com.example.test.service.LogMessagesService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.generated.tables.Log;
import org.jooq.generated.tables.records.LogRecord;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class LogMessagesServiceImpl implements LogMessagesService {

    @Autowired
    private Connector connector;

    @Override
    public boolean saveLogMessagesToDataBase(List<LogRecord> logMessagesList) {
        try(Connection con = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPass())) {
            DSLContext dsl = DSL.using(con, SQLDialect.POSTGRES);
            Date date = new Date(Calendar.getInstance().getTime().getTime());
            for(LogRecord logMessage : logMessagesList) {
                dsl.insertInto(Log.LOG, Log.LOG.APP_ID, Log.LOG.TAG, Log.LOG.MESSAGE, Log.LOG.TIMESTAMP, Log.LOG.EX)
                        .values(logMessage.getAppId(), logMessage.getTag(), logMessage.getMessage(), date,
                                logMessage.getEx()).execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<LogMessage> getFromDataBaseLogMessagesById(List<Integer> listIdLogMessages) {
        List<LogRecord> logRecordsList;
        List<LogMessage> logList = null;
        try(Connection con = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPass())) {
            DSLContext dsl = DSL.using(con, SQLDialect.POSTGRES);
            logRecordsList = dsl.selectFrom(Log.LOG).where(Log.LOG.APP_ID.in(listIdLogMessages)).fetch();
            logList = convertQueryResultsToModelObjects(logRecordsList);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return logList;
    }

    private List<LogMessage> convertQueryResultsToModelObjects(List<LogRecord> queryLogResult) {
        List<LogMessage> logMessagesList = new ArrayList<>();
        LogMessage logMessage;
        for(LogRecord logRecord : queryLogResult) {
            logMessage = new LogMessage();
            logMessage.setId(logRecord.getId());
            logMessage.setAppId(logRecord.getAppId());
            logMessage.setTag(logRecord.getTag());
            logMessage.setMessage(logRecord.getMessage());
            logMessage.setTimeStamp(logRecord.getTimestamp()!=null?logRecord.getTimestamp().toLocalDate():null);
            logMessage.setEx(logRecord.getEx());
            logMessagesList.add(logMessage);
        }
        return logMessagesList;
    }
}
