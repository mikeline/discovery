package com.netcracker.discovery.service;
import com.netcracker.discovery.model.Node;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NodeService {
    private final Map<UUID, Node> storage = new ConcurrentHashMap<>();

    public Node get(UUID id) {
        return storage.get(id);
    }

    public Collection<Node> getAll() {
        return storage.values();
    }

    public Node create(Node node) {
        Node res = new Node(node.getAddress(), node.getPort(), node.getBrokerAddress(), node.getBrokerPort());

        storage.put(res.getId(), res);

        return res;
    }

    public void delete(UUID id) {
        storage.remove(id);
    }
}
