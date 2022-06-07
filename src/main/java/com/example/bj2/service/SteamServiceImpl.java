package com.example.bj2.service;

import com.example.bj2.domain.Steam;
import com.example.bj2.dto.ListDTO;
import com.example.bj2.dto.ListResponseDTO;
import com.example.bj2.dto.SteamDTO;
import com.example.bj2.mapper.SteamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
@Service
public class SteamServiceImpl implements SteamService{
    private final SteamMapper steamMapper;
    private final ModelMapper modelMapper;
    @Override
    public void insert(Steam steam) {

        steamMapper.insert(steam);
    }

    @Override
    public ListResponseDTO<SteamDTO> getList(ListDTO listDTO) {

        List<Steam> boardList = steamMapper.selectList(listDTO);

        List<SteamDTO> dtoList =
                boardList.stream()
                        .map(board -> modelMapper.map(board, SteamDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<SteamDTO>builder()
                .dtoList(dtoList)
                .total(steamMapper.getTotal(listDTO))
                .build();
    }

}
