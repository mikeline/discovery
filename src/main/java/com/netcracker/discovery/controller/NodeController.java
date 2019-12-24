package com.netcracker.discovery.controller;

import com.netcracker.discovery.model.Node;
import com.netcracker.discovery.repo.NodeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
@RequestMapping(value = "/node")
@RequiredArgsConstructor
public class NodeController {

    private final NodeRepo nodeRepo;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Node>> get(@PathVariable String id) {

        Optional<Node> node = nodeRepo.findById(UUID.fromString(id));

        return new ResponseEntity<>(node, OK);
    }

    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Collection<Node>> getAll() {

        List<Node> nodes = nodeRepo.findAll();

        return new ResponseEntity<>(nodes, OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Node> create(@RequestBody Node node) {
        Node res = nodeRepo.save(node);
        return new ResponseEntity<>(res, OK);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseBody
    public ResponseEntity<Node> delete(@PathVariable String id) {
        nodeRepo.deleteById(UUID.fromString(id));
        return new ResponseEntity<>(NO_CONTENT);
    }

}
