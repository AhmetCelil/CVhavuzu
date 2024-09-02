package com.adaytanitim.cvhavuzu.repository;

import com.adaytanitim.cvhavuzu.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {
    @Query("SELECT c FROM Candidate c WHERE c.soyad = :soyad " +
            "AND c.sirketIsmi = :sirketIsmi")
    List<Candidate> findBySoyadAndSirketIsmi(@Param("soyad") String soyad,
                                             @Param("sirketIsmi") String sirketIsmi);

}
