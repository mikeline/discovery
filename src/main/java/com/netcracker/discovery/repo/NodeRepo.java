package com.netcracker.discovery.repo;

import com.netcracker.discovery.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NodeRepo extends JpaRepository<Node, UUID> {
}
