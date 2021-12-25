package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    private final Environment env;

    private final WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        logger.info("PORT: " + env.getProperty("local.server.port"));
        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
//        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }


}
