package com.example.test.model;

import java.util.List;

public class LogMessageList {

    private List<LogMessage> logMessageList;

    public LogMessageList() {
        super();
    }

    public LogMessageList(List<LogMessage> logMessageList) {
        this.logMessageList = logMessageList;
    }

    public List<LogMessage> getLogMessageList() {
        return logMessageList;
    }

    public void setLogMessageList(List<LogMessage> logMessageList) {
        this.logMessageList = logMessageList;
    }

    @Override
    public String toString() {
        return "LogMessageList{" +
                "logMessageList=" + logMessageList +
                '}';
    }
}
