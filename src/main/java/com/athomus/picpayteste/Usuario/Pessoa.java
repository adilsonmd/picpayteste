package com.athomus.picpayteste.Usuario;

import com.athomus.picpayteste.Carteira.Carteira;

import java.util.UUID;

public abstract class Pessoa implements Usuario {
    private String id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private Carteira carteira;
    public Pessoa() {
        this.setCarteira(new Carteira(this));
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public double getSaldo() {
        return this.getCarteira().getValor().doubleValue();
    }
}
