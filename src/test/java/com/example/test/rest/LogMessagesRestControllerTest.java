package com.example.test.rest;

import com.example.test.model.LogMessage;
import com.example.test.service.LogMessagesService;
import com.example.test.service.impl.LogMessagesServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LogMessagesRestControllerTest {
    @Mock
    private LogMessagesService logMessagesService;
    @InjectMocks
    LogMessagesRestController sut;

    @Test
    public void getLogMessages() throws Exception {
        //testing
        sut.getLogMessages();
        //validate
        verify(logMessagesService).getFromDataBaseLogMessagesById(new ArrayList<>());
    }

    @Test
    public void setLogMessages() throws Exception {
        //testing
        sut.setLogMessages("123", "123", "123");
        //validate
        verify(logMessagesService).getFromDataBaseLogMessagesById(new ArrayList<>());
    }
}