package com.example.test.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogMessagesRestControllerIT {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getLogMessages() throws Exception {
        restTemplate.exchange("http://localhost:8080/log-messages/get-log-messages", HttpMethod.POST, null,
                new ParameterizedTypeReference<Object>() {
                });
    }

}