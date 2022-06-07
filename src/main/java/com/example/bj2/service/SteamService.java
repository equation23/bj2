package com.example.bj2.service;

import com.example.bj2.domain.Steam;
import com.example.bj2.dto.ListDTO;
import com.example.bj2.dto.ListResponseDTO;
import com.example.bj2.dto.SteamDTO;

public interface SteamService {
    void insert (Steam steam);
    ListResponseDTO<SteamDTO> getList (ListDTO listDTO);
}
