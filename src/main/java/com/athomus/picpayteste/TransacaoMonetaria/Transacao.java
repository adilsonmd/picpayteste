package com.athomus.picpayteste.TransacaoMonetaria;

import com.athomus.picpayteste.Transferencia.Transferencia;
import com.athomus.picpayteste.Usuario.Usuario;

import java.time.LocalDateTime;

public class Transacao {
    private String id;
    private Transferencia transferencia;
    private LocalDateTime create_date;
    private boolean transacaoDesfeita;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public boolean isTransacaoDesfeita() {
        return transacaoDesfeita;
    }

    public void setTransacaoDesfeita(boolean transacaoDesfeita) {
        this.transacaoDesfeita = transacaoDesfeita;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Usuário " +  this.getTransferencia().getPagador().getNomeCompleto() + " está transferindo ");
        s.append("R$ " + this.getTransferencia().getValor().toString() + " ");
        s.append("para o usuário " + this.getTransferencia().getRecebedor().getNomeCompleto());

        return s.toString();
    }
}
