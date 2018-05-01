package com.example.test.rest;

import com.example.test.model.LogMessage;
import com.example.test.service.LogMessagesService;
import com.example.test.service.impl.LogMessagesServiceImpl;
import org.jooq.generated.tables.records.LogRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.annotation.Resource;
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

    @Resource
    private List<Integer> integers;

    @Test
    public void getLogMessages() throws Exception {
        //validate
        //verify(logMessagesService).getFromDataBaseLogMessagesById(new ArrayList<>());
    }

    @Test
    public void setLogMessages() throws Exception {
        //validate
        //List<Integer> integers = new ArrayList<>();
        //integers.add(1);
//        verify(logMessagesService).getFromDataBaseLogMessagesById(integers);
    }
}