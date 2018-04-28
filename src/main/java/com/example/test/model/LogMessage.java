package com.example.test.model;

import java.time.LocalDate;

public class LogMessage {

    private long id;
    private String tag;
    private LocalDate timeStamp;
    private String message;
    private String ex;

    public LogMessage() {
    }

    public LogMessage(long id, String tag, LocalDate timeStamp, String message, String ex) {
        this.id = id;
        this.tag = tag;
        this.timeStamp = timeStamp;
        this.message = message;
        this.ex = ex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", ex='" + ex + '\'' +
                '}';
    }
}
