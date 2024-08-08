package com.adaytanitim.cvhavuzu.model;

import com.adaytanitim.cvhavuzu.validation.ValidEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "humanresource")
public class HumanResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @NotNull
    private String ad;

    @NotNull
    private String soyad;
    private String adres;
    private Boolean aktifCalisiyorMu;

    @ValidEmail // custom validasyon eğer uygunsa geçer
    private String email;
    private LocalDate iseBaslamaTarihi;
    private LocalDate istenCikisTarihi;
    private String sirketIsmi;

    private String telefon;
    private Integer yetki;

}
