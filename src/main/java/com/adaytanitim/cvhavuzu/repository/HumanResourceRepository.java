package com.adaytanitim.cvhavuzu.repository;

import com.adaytanitim.cvhavuzu.model.HumanResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HumanResourceRepository extends JpaRepository<HumanResource, Long> {
}
