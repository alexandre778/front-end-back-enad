package com.agm.classificados.repository;

import com.agm.classificados.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    // 🔍 O Spring Data cria automaticamente a query baseada no nome do método
    List<Anuncio> findByCategoria(String categoria);
}
