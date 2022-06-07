package com.example.bj2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteamDTO {
    private Integer sno;
    private String title;
    private String image;
    private String link;
    private String original_price;
    private String sale_price;
    private String sale_percent;
    private LocalDateTime regdate;
}
