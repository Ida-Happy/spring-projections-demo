package com.example.demo.client;

import com.example.demo.domain.DemoOrder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class OrderClient {
    private final RestTemplate restTemplate;

    public DemoOrder getOrderByOrderId(String orderId) {
        return restTemplate.exchange("http://localhost:8081/order/" + orderId,
                                     HttpMethod.GET,
                                     null,
                                     DemoOrder.class).getBody();
    }
}
