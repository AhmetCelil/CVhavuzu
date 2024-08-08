package com.adaytanitim.cvhavuzu.service;

import com.adaytanitim.cvhavuzu.model.HumanResource;
import com.adaytanitim.cvhavuzu.repository.CandidateRepository;
import com.adaytanitim.cvhavuzu.repository.HumanResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HumanResourceService {

    @Autowired
    private HumanResourceRepository repository;


    public HumanResource saveHumanResource(HumanResource humanResource) {
        return repository.save(humanResource);
    }

    public List<HumanResource> getAllHumanResources() {
        return repository.findAll();
    }

    public Optional<HumanResource> getHumanResourceById(Long id) {
        return repository.findById(id);
    }

    public void deleteHumanResource(Long id) {
        repository.deleteById(id);
    }
}
