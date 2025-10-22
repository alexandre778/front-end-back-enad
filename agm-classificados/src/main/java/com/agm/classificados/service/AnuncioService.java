package com.agm.classificados.service;


import com.agm.classificados.model.Anuncio;
import com.agm.classificados.repository.AnuncioRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AnuncioService {


private final AnuncioRepository repo;


public AnuncioService(AnuncioRepository repo) {
this.repo = repo;
}


public List<Anuncio> listarPorCategoria(String categoria) {
return repo.findByCategoria(categoria);
}


public Anuncio salvar(Anuncio a) {
return repo.save(a);
}


public List<Anuncio> listarTodos() {
return repo.findAll();
}
}