package com.adaytanitim.cvhavuzu.controller;

import com.adaytanitim.cvhavuzu.dto.CandidateDTO;
import com.adaytanitim.cvhavuzu.dto.KisiselGelisimDTO;
import com.adaytanitim.cvhavuzu.model.Candidate;
import com.adaytanitim.cvhavuzu.model.KisiselGelisim;
import com.adaytanitim.cvhavuzu.service.CandidateService;
import com.adaytanitim.cvhavuzu.validation.ValidEmail;
import org.hibernate.dialect.function.array.PostgreSQLArrayTrimEmulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setAd(candidateDTO.getAd());
        candidate.setAdres(candidateDTO.getAdres());
        candidate.setAktifCalisiyorMu(candidateDTO.getAktifCalisiyorMu());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setIseBaslamaTarihi(candidateDTO.getIseBaslamaTarihi());
        candidate.setIstenCikisTarihi(candidateDTO.getIstenCikisTarihi());
        candidate.setSirketIsmi(candidateDTO.getSirketIsmi());
        candidate.setSoyad(candidateDTO.getSoyad());
        candidate.setTelefon(candidateDTO.getTelefon());
        candidate.setYetki(candidateDTO.getYetki());
/*
        KisiselGelisim kisiselGelisim = new KisiselGelisim();
        kisiselGelisim.setSosyalMedyaLinki(candidateDTO.getKisiselGelisim().getSosyalMedyaLinki());
        kisiselGelisim.setGithubLinki(candidateDTO.getKisiselGelisim().getGithubLinki());
        kisiselGelisim.setIsDeneyimleri(candidateDTO.getKisiselGelisim().getIsDeneyimleri());
        kisiselGelisim.setSertifikalar(candidateDTO.getKisiselGelisim().getSertifikalar());

        candidate.setKisiselGelisim(kisiselGelisim);*/

        Candidate savedCandidate = candidateService.saveCandidate(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }


    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate savedCandidate = candidateService.saveCandidate(candidate);
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


    /*@PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        try {
            Candidate savedCandidate = candidateService.saveCandidate(candidate);
            return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            // Return a 500 Internal Server Error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
        List<CandidateDTO> candidateDTOList = candidateService.getAllCandidates();
        return new ResponseEntity<>(candidateDTOList, HttpStatus.OK);
    }


}
