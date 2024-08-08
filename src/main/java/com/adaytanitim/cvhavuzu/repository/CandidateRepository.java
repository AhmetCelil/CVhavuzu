package com.adaytanitim.cvhavuzu.repository;

import com.adaytanitim.cvhavuzu.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

}
