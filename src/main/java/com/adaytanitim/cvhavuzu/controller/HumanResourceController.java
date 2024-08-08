package com.adaytanitim.cvhavuzu.controller;

import com.adaytanitim.cvhavuzu.model.HumanResource;
import com.adaytanitim.cvhavuzu.service.HumanResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/human-resources")
public class HumanResourceController {

    @Autowired
    private HumanResourceService service;

    @PostMapping
    public ResponseEntity<HumanResource> createHumanResource(@RequestBody HumanResource humanResource) {
        return new ResponseEntity<>(service.saveHumanResource(humanResource), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HumanResource>> getAllHumanResources() {
        return new ResponseEntity<>(service.getAllHumanResources(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HumanResource> getHumanResourceById(@PathVariable Long id) {
        Optional<HumanResource> humanResource = service.getHumanResourceById(id);
        return humanResource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<HumanResource> updateHumanResource(@PathVariable Long id, @RequestBody HumanResource humanResource) {
        if (service.getHumanResourceById(id).isPresent()) {
            humanResource.setUserid(id);
            return new ResponseEntity<>(service.saveHumanResource(humanResource), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHumanResource(@PathVariable Long id) {
        if (service.getHumanResourceById(id).isPresent()) {
            service.deleteHumanResource(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
