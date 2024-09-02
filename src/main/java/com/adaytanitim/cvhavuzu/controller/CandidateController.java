package com.adaytanitim.cvhavuzu.controller;

import com.adaytanitim.cvhavuzu.dto.CandidateDTO;
import com.adaytanitim.cvhavuzu.model.Candidate;
import com.adaytanitim.cvhavuzu.model.KisiselGelisim;
import com.adaytanitim.cvhavuzu.service.CandidateService;
import com.adaytanitim.cvhavuzu.validation.ValidEmail;
import org.hibernate.dialect.function.array.PostgreSQLArrayTrimEmulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/add")
    public ResponseEntity<Candidate> saveCandidate( @RequestBody CandidateDTO candidateDto) {
        Candidate savedCandidate = candidateService.saveCandidate(candidateDto);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

    @PostMapping("/{userID}")
    @ValidEmail
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long userID, @ValidEmail @RequestBody Candidate candidate) {
        candidate.setUserID(userID);
        Candidate updatedCandidate = candidateService.updateCandidate(candidate);
        return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable String userID) {
        candidateService.deleteCandidate(userID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userID}")
    public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable String userID) {
        Optional<CandidateDTO> candidateDtoOptional = candidateService.getCandidateById(userID);
        if (candidateDtoOptional.isPresent()) {
            return ResponseEntity.ok(candidateDtoOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/all-candidates")
    public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
        List<CandidateDTO> candidates = candidateService.getAllCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }
}
