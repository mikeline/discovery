package com.netcracker.discovery.controller;

import com.netcracker.discovery.model.Node;
import com.netcracker.discovery.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
@RequestMapping(value = "/node")
@RequiredArgsConstructor
public class NodeController {

    private final NodeService nodeService;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Node> get(@PathVariable String id) {
        return new ResponseEntity<>(nodeService.get(UUID.fromString(id)), OK);
    }

    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Collection<Node>> getAll() {
        return new ResponseEntity<>(nodeService.getAll(), OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Node> create(@RequestBody Node node) {
        Node res = nodeService.create(node);
        return new ResponseEntity<>(res, OK);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseBody
    public ResponseEntity<Node> delete(@PathVariable String id) {
        nodeService.delete(UUID.fromString(id));
        return new ResponseEntity<>(NO_CONTENT);
    }



}
