package com.example.gatewayservice.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gateway")
public class GatewayController {
    private final DiscoveryClient discoveryClient;

    public GatewayController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }
    @GetMapping
    public List<String> getInstances() {
        List<String> allInstances = discoveryClient.getServices();
        return allInstances;
    }
}
