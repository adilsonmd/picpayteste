package com.athomus.picpayteste.TransacaoMonetaria;

import com.athomus.picpayteste.ModelInterface;
import com.athomus.picpayteste.Transferencia.Transferencia;

import java.time.LocalDateTime;
import java.util.List;

public class TransacaoModel {
    public Transacao getById(String id) {
        Transacao t = new Transacao();
        t.setId(id);
        t.setTransferencia(Transferencia.mock());
        t.setCreate_date(LocalDateTime.now());

        return t;
    }

    public void insert(Transacao transacao) {
        System.out.println(transacao.toString());
    }
}
