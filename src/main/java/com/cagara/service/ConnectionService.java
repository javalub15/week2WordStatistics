package com.cagara.service;

import org.springframework.web.client.RestTemplate;

public class ConnectionService {

    public static String getContent(String URL) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL, String.class);
    }
}
