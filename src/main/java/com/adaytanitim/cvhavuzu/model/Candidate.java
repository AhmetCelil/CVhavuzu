package com.adaytanitim.cvhavuzu.model;

import com.adaytanitim.cvhavuzu.validation.ValidEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    //@NotNull(message = "ad boş olamaz")
    private String ad;
    //@NotNull(message = "soyad boş olamaz")  //validasyon
    private String soyad;
    private String adres;
    private Boolean aktifCalisiyorMu;
    @ValidEmail
    private String email;
    private LocalDate iseBaslamaTarihi;
    private LocalDate istenCikisTarihi;
    private String sirketIsmi;
    private String telefon;
    private Integer yetki;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kisisel_gelisim_id")
    private KisiselGelisim kisiselGelisim;

    public void setUserID(Long userid) {
        this.userid = userid;
    }


}
