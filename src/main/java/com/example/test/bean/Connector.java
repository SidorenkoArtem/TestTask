package com.example.test.bean;

import org.springframework.stereotype.Component;

@Component
public class Connector {
    public String getUrl() {
        return "jdbc:postgresql://localhost:5432/logData";
    }

    public String getUser() {
        return "postgres";
    }

    public String getPass() {
        return "Sandefjord123";
    }
}
