package com.athomus.picpayteste.Transferencia;

import com.athomus.picpayteste.Notificacao.Notificacao;
import com.athomus.picpayteste.Notificacao.NotificacaoEmail;
import com.athomus.picpayteste.Security.ConexaoSegura;
import com.athomus.picpayteste.Security.ISecurity;
import com.athomus.picpayteste.Servicos.AutorizadorService;
import com.athomus.picpayteste.TransactionManager;
import com.athomus.picpayteste.Usuario.Usuario;

public class TransferenciaController {

    public boolean transferirDinheiro(Transferencia transferencia, ISecurity conexao) throws Exception {
        TransactionManager transaction = new TransactionManager();
        try {
            // TODO transaction
            conexao.estabelecerConexaoSegura();

            validarDados(transferencia);

            if (!AutorizadorService.isAutorizado(transferencia)) {
                throw new Exception("Transferência não autorizada");
            }

            realizarTransferencia(transferencia);
            enviarNotificacao(transferencia);
            transaction.commit();

            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            transaction.rollback();
            throw ex;
        } finally {
            transaction.close();
        }
    }

    private void validarDados(Transferencia transferencia) throws Exception{
        if (transferencia.getPagador() == null) {
            throw new Exception("Dados inválidos");
        }
        if (transferencia.getRecebedor() == null) {
            throw new Exception("Dados inválidos");
        }
    }

    private void enviarNotificacao(Transferencia transferencia) {
        // TODO obter configuração do usuário para preferencia de notificação (Email ou SMS) e instanciar a partir dela
        Notificacao notificacao = new NotificacaoEmail();

        notificacao.enviar((Usuario) transferencia.getRecebedor(), "Transferência no valor de " + transferencia.getValor() + " realizada com sucesso.");
    }

    private void realizarTransferencia(Transferencia transferencia) throws Exception {
        try {
            transferencia.getPagador().pagar(transferencia.getValor());
            transferencia.getRecebedor().receber(transferencia.getValor());
        } catch (Exception ex) {
            throw ex;
        }
    }
}
