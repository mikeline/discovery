package com.netcracker.discovery;

import com.netcracker.discovery.service.NodeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }

    @Bean
    public NodeService nodeService() {
        return new NodeService();
    }

}
