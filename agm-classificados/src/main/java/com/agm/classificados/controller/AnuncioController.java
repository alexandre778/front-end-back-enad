package com.agm.classificados.controller;

import com.agm.classificados.model.Anuncio;
import com.agm.classificados.service.AnuncioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/anuncios")
public class AnuncioController {

    private final AnuncioService service;

    public AnuncioController(AnuncioService service) {
        this.service = service;
    }

    // Página inicial de listagem
    @GetMapping
    public String listarTodos(Model model) {
        List<Anuncio> anuncios = service.listarTodos();
        model.addAttribute("anuncios", anuncios);
        return "anuncios-lista"; // templates/anuncios-lista.html
    }

    // Filtro por categoria
    @GetMapping("/categoria/{categoria}")
    public String listarPorCategoria(@PathVariable String categoria, Model model) {
        List<Anuncio> anuncios = service.listarPorCategoria(categoria);
        model.addAttribute("anuncios", anuncios);
        model.addAttribute("categoria", categoria);
        return "anuncios-lista"; // reutiliza o mesmo HTML
    }

    // Página de formulário para novo anúncio
    @GetMapping("/novo")
    public String novoAnuncioForm(Model model) {
        model.addAttribute("anuncio", new Anuncio());
        return "anuncio-form"; // templates/anuncio-form.html
    }

    // Enviar formulário (salvar no banco)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Anuncio anuncio) {
        service.salvar(anuncio);
        return "redirect:/anuncios";
    }
}
