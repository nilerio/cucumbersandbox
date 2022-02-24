package com.pberube.cucumber;

import com.pberube.cucumber.endpoints.rest.Handler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringContextTest {

    @Autowired
    private Handler controller;


    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
