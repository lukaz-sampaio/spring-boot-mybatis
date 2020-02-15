package com.lab.fruta;

import com.lab.fruta.familia.FamiliaFruta;

/**
 *
 * @author lucas
 */
public class Fruta {

    private Long id;
    private String nome;
    private String nomeCientifico;
    private FamiliaFruta familia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public FamiliaFruta getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaFruta familia) {
        this.familia = familia;
    }
}
