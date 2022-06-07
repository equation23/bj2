package com.example.bj2.mapper;

import com.example.bj2.domain.Steam;
import com.example.bj2.dto.ListDTO;

import java.util.List;

public interface SteamMapper {
    
    void insert (Steam steam);
    List<Steam> selectList (ListDTO listDTO);
    int getTotal(ListDTO listDTO);
}
