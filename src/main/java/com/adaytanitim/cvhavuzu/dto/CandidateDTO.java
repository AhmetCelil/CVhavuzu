package com.adaytanitim.cvhavuzu.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {
    private Long userid;
    private String ad;
    private String adres;
    private Boolean aktifCalisiyorMu;
    private String email;
    private LocalDate iseBaslamaTarihi;
    private LocalDate istenCikisTarihi;
    private String sirketIsmi;
    private String soyad;
    private String telefon;
    private Integer yetki;
    private KisiselGelisimDTO kisiselGelisim;


}
