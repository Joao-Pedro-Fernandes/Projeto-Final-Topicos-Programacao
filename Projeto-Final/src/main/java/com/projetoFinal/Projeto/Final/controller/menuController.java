package com.projetoFinal.Projeto.Final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class menuController {

    @GetMapping()
    public String menuPrincipal(){
        return "/menu/principal";
    }
}
