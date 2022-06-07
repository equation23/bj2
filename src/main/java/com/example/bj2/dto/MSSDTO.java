package com.example.bj2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MSSDTO {

    private Long mno;
    private String title;
    private String maker;
    private String link;
    private String image;
    private Integer originalPrice;
    private Integer salePrice;

    private String salePercent;
    private LocalDateTime regDate;
}
