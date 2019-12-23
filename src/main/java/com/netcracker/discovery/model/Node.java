package com.netcracker.discovery.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@NoArgsConstructor
@ToString
public class Node {
    private UUID id;

    private String address;

    private String port;

    private String brokerAddress;

    private String brokerPort;

    public Node(String address, String port, String brokerAddress, String brokerPort) {
        this.id = UUID.randomUUID();
        this.address = address;
        this.port = port;
        this.brokerAddress = brokerAddress;
        this.brokerPort = brokerPort;
    }
}
