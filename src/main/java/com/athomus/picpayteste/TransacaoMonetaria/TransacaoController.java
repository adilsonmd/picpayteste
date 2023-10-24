package com.athomus.picpayteste.TransacaoMonetaria;

import com.athomus.picpayteste.TransactionManager;
import com.athomus.picpayteste.Transferencia.Transferencia;
import com.athomus.picpayteste.Transferencia.TransferenciaController;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoController {
    public TransacaoController() {
    }

    public Transacao obterTransacao(String id) {
        TransacaoModel model = new TransacaoModel();
        Transacao transacao = model.getById(id);

        return transacao;
    }
    public void salvarTransacao(Transferencia transferencia) {
        TransactionManager transactionManager = new TransactionManager();
        try {
            TransacaoModel model = new TransacaoModel();

            Transacao transacao = new Transacao();
            transacao.setId(UUID.randomUUID().toString());
            transacao.setTransferencia(transferencia);
            transacao.setCreate_date(LocalDateTime.now());

            model.insert(transacao);

            transactionManager.commit();
        } catch (Exception ex) {
            transactionManager.rollback();
            throw ex;
        } finally {
            transactionManager.close();
        }
    }

    public void atualizarTransacao(String id) {

    }
}
