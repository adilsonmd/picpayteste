package com.athomus.picpayteste;

import com.athomus.picpayteste.Depositos.DepositoController;
import com.athomus.picpayteste.Security.ConexaoSegura;
import com.athomus.picpayteste.Security.ISecurity;
import com.athomus.picpayteste.Transferencia.Transferencia;
import com.athomus.picpayteste.Transferencia.TransferenciaController;
import com.athomus.picpayteste.Usuario.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferenciaTeste {
    private Transferencia criarObjetoTransferencia(String valor, String nomeUsuario1, String nomeUsuario2) {
        Transferencia transferencia = new Transferencia();

        IPagador u1 = new PessoaFisica(nomeUsuario1, "42931268301", "usuario1@email.teste");
        IRecebedor u2 = new PessoaJuridica(nomeUsuario2, "46650169198528", "usuario2@email.teste");

        transferencia.setPagador(u1);
        transferencia.setRecebedor(u2);
        transferencia.setValor(valor);

        return transferencia;
    }
    @Test
    public void transferenciaLancaExceptionQuandoNumeroNegativo() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                criarObjetoTransferencia("-50.40", "Adilson Alves Mattos", "PicPay Corporation"));
    }

    @Test
    public void transferenciaCria() throws Exception {
        Transferencia transferencia = criarObjetoTransferencia("10.0", "Adilson Alves Mattos", "PicPay Corp.");

        assertEquals("10.0", transferencia.getValor().toString());
    }

    @Test
    public void transferenciaNaoRealizada() throws Exception {
        Transferencia transferencia = criarObjetoTransferencia("10.0", "Adilson Alves Mattos", "PicPay Corp.");
        TransferenciaController controller = new TransferenciaController();
        ISecurity conexao = new ConexaoSegura();

        Exception exception = assertThrows(Exception.class, () -> controller.transferirDinheiro(transferencia, conexao));
    }

    @Test
    public void transferenciaRealizada() throws Exception {
        DepositoController depositoController = new DepositoController();
        TransferenciaController controller = new TransferenciaController();
        ISecurity conexao = new ConexaoSegura();

        Transferencia transferencia = criarObjetoTransferencia("10.0", "Adilson Alves Mattos", "PicPay Corp.");
        depositoController.depositar(transferencia.getRecebedor(), new BigDecimal("20.0"));

        assertEquals(true, controller.transferirDinheiro(transferencia, conexao));
    }
}
