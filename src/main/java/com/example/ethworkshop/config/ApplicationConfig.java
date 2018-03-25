package com.example.ethworkshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ethworkshop.ethereum.EthereumConfigProperties;
import com.example.ethworkshop.ethereum.EthereumService;

@Configuration
public class ApplicationConfig {

    @Autowired
    private EthereumConfigProperties ethereumConfigProperties;

    @Bean
    public EthereumService ethereumService() throws Exception {
        return new EthereumService(ethereumConfigProperties);
    }
}
