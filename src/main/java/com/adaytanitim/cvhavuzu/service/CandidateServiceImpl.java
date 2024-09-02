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
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate saveCandidate(CandidateDTO candidateDto) {
        // DTO'dan Entity'ye dönüştürme
        Candidate candidate = new Candidate();
        candidate.setUserid(candidateDto.getUserid());
        candidate.setAd(candidateDto.getAd());
        candidate.setSoyad(candidateDto.getSoyad());
        candidate.setAdres(candidateDto.getAdres());
        candidate.setAktifCalisiyorMu(candidateDto.getAktifCalisiyorMu());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setIseBaslamaTarihi(candidateDto.getIseBaslamaTarihi());
        candidate.setIstenCikisTarihi(candidateDto.getIstenCikisTarihi());
        candidate.setSirketIsmi(candidateDto.getSirketIsmi());
        candidate.setTelefon(candidateDto.getTelefon());
        candidate.setYetki(candidateDto.getYetki());
        // KisiselGelisim DTO'sunu Entity'ye dönüştürme
        KisiselGelisimDTO kisiselGelisimDto = candidateDto.getKisiselGelisim();
        if (kisiselGelisimDto != null) {
            KisiselGelisim kisiselGelisim = new KisiselGelisim();
            kisiselGelisim.setSosyalMedyaLinki(kisiselGelisimDto.getSosyalMedyaLinki());
            kisiselGelisim.setGithubLinki(kisiselGelisimDto.getGithubLinki());
            kisiselGelisim.setIsDeneyimleri(kisiselGelisimDto.getIsDeneyimleri());
            kisiselGelisim.setSertifikalar(kisiselGelisimDto.getSertifikalar());
            candidate.setKisiselGelisim(kisiselGelisim);
        }
        // Candidate nesnesini veri tabanına kaydetme
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


    public List<CandidateDTO> getAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidates.stream().map(this::convertToDto).collect(Collectors.toList());  //streamle maplıyoruz
    }

    private CandidateDTO convertToDto(Candidate candidate) { //entityi mapliyoruz
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

        return candidateDto;
    }
}
