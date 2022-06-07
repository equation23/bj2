package com.example.bj2.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MSS {

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
