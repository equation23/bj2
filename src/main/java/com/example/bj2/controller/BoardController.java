package com.example.bj2.controller;

import com.example.bj2.dto.ListDTO;
import com.example.bj2.dto.ListResponseDTO;
import com.example.bj2.dto.PageMaker;
import com.example.bj2.dto.SteamDTO;
import com.example.bj2.service.SteamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/project")
public class BoardController {
private final SteamService steamService;
    @GetMapping("/search")
    public void mainSearch() {

    }

    @GetMapping("/steam")
    public void steamSale(ListDTO listDTO, Model model) {
        ListResponseDTO<SteamDTO> responseDTO = steamService.getList(listDTO);

        model.addAttribute("dtoList", responseDTO.getDtoList());

        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));

    }

    @GetMapping("/mss")
    public void mssSale() {

    }
}