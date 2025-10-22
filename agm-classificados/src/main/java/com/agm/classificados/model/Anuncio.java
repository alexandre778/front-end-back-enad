package com.agm.classificados.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "anuncio")
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria; // carros, imoveis, negocios, empregos
    private String anunciante;
    private String titulo;

    @Column(length = 2000)
    private String descricao;

    private BigDecimal preco;

    public Anuncio() {}

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getAnunciante() { return anunciante; }
    public void setAnunciante(String anunciante) { this.anunciante = anunciante; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}
