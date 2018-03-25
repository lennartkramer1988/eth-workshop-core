package com.example.ethworkshop.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ethworkshop.ethereum.EthereumService;

@Service
public class GreetingService {

    private final EthereumService ethereumService;

    @Autowired
    public GreetingService(EthereumService ethereumService) {
        this.ethereumService = ethereumService;
    }

    public Greeting getGreeting() throws Exception {
        return ethereumService.getGreeting();
    }
}
