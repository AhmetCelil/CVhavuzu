package com.adaytanitim.cvhavuzu.service;

import com.adaytanitim.cvhavuzu.dto.CandidateDTO;
import com.adaytanitim.cvhavuzu.dto.KisiselGelisimDTO;
import com.adaytanitim.cvhavuzu.model.Candidate;
import com.adaytanitim.cvhavuzu.model.KisiselGelisim;
import com.adaytanitim.cvhavuzu.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(String userID) {
        candidateRepository.deleteById(userID);
    }

    public Optional<CandidateDTO> getCandidateById(String userID) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(userID);

        if (candidateOptional.isPresent()) {
            Candidate candidate = candidateOptional.get();

            CandidateDTO candidateDto = new CandidateDTO();
            candidateDto.setUserid(candidate.getUserid());
            candidateDto.setAd(candidate.getAd());
            candidateDto.setSoyad(candidate.getSoyad());
            candidateDto.setAdres(candidate.getAdres());
            candidateDto.setAktifCalisiyorMu(candidate.getAktifCalisiyorMu());
            candidateDto.setEmail(candidate.getEmail());
            candidateDto.setIseBaslamaTarihi(candidate.getIseBaslamaTarihi());
            candidateDto.setIstenCikisTarihi(candidate.getIstenCikisTarihi());
            candidateDto.setSirketIsmi(candidate.getSirketIsmi());
            candidateDto.setTelefon(candidate.getTelefon());
            candidateDto.setYetki(candidate.getYetki());

            KisiselGelisim kisiselGelisim = candidate.getKisiselGelisim();
            if (kisiselGelisim != null) {
                KisiselGelisimDTO kisiselGelisimDto = new KisiselGelisimDTO();
                kisiselGelisimDto.setSosyalMedyaLinki(kisiselGelisim.getSosyalMedyaLinki());
                kisiselGelisimDto.setGithubLinki(kisiselGelisim.getGithubLinki());
                kisiselGelisimDto.setIsDeneyimleri(kisiselGelisim.getIsDeneyimleri());
                kisiselGelisimDto.setSertifikalar(kisiselGelisim.getSertifikalar());
                candidateDto.setKisiselGelisim(kisiselGelisimDto);
            }

            return Optional.of(candidateDto);
        }

        return Optional.empty();
    }

    /* @Override
    public Optional<Candidate> getCandidateById(String userID) {
        return candidateRepository.findById(userID);
    }*/

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}
