package com.adaytanitim.cvhavuzu.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "kisisel_gelisim")
public class KisiselGelisim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sosyalMedyaLinki;
    private String githubLinki;
    private String isDeneyimleri;
    private String sertifikalar;


    @OneToOne(mappedBy = "kisiselGelisim")
    private Candidate candidate;

}
