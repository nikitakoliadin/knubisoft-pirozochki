package com.knubisoft.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResponseHeaderTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCustomResponseHeader() {
        HttpHeaders headers;
        headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("/hello", HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getHeaders().get("UUID"));
        assertTrue(UUID.fromString(response.getHeaders().get("UUID").get(0)) instanceof UUID);
    }
}