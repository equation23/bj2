package com.example.bj2.domain;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Steam {
    private Integer sno;
    private String title;
    private String image;
    private String link;
    private String original_price;
    private String sale_price;
    private String sale_percent;

    private LocalDateTime regdate;
}
