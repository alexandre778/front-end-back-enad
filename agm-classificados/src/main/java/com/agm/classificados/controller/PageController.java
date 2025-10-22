package com.agm.classificados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index"; // templates/index.html
    }

    @GetMapping("/carros")
    public String carros() {
        return "carros"; // templates/carros.html
    }

    @GetMapping("/imoveis")
    public String imoveis() {
        return "imoveis"; // templates/imoveis.html
    }

    @GetMapping("/negocios")
    public String negocios() {
        return "negocios"; // templates/negocios.html
    }

    @GetMapping("/empregos")
    public String empregos() {
        return "empregos"; // templates/empregos.html
    }
}
