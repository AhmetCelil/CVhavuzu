package com.adaytanitim.cvhavuzu.service;

import com.adaytanitim.cvhavuzu.dto.CandidateDTO;
import com.adaytanitim.cvhavuzu.model.Candidate;
import java.util.List;
import java.util.Optional;

public interface CandidateService {
    Candidate saveCandidate(Candidate candidate);
    Candidate updateCandidate(Candidate candidate);
    void deleteCandidate(String userID);
    Optional<CandidateDTO> getCandidateById(String userID);
    List<CandidateDTO> getAllCandidates();
}
