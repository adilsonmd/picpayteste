package com.athomus.picpayteste.Carteira;

import com.athomus.picpayteste.Usuario.Usuario;

import java.math.BigDecimal;
import java.util.UUID;

public class Carteira {
    private UUID idCarteira;
    private BigDecimal valor;
    private Usuario dono;

    public Carteira(Usuario dono) {
        this.dono = dono;
        this.valor = BigDecimal.ZERO;
    }

    public UUID getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(UUID idCarteira) {
        this.idCarteira = idCarteira;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public void adicionarValor(BigDecimal valor) {
        this.valor = this.valor.add(valor);
    }

    public void retirarValor(BigDecimal valor) throws Exception {
        if (valor.signum() == -1) {
            throw new Exception("Número não pode ser negativo");
        }

        if (this.valor.subtract(valor).signum() == -1) {
            throw new Exception("Você não possui créditos para esta operação");
        }

        this.valor = this.valor.subtract(valor);
    }
}
