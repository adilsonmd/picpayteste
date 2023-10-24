package com.athomus.picpayteste;

import com.athomus.picpayteste.Servicos.Autorizacao;
import com.athomus.picpayteste.Servicos.AutorizadorService;
import com.athomus.picpayteste.Transferencia.Transferencia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutorizacaoTeste {
    @Test
    public void testarAutorizacao() {
        Transferencia transferencia = new Transferencia();

        Autorizacao autorizado = AutorizadorService.postAutorizacao(transferencia);

        assertEquals("Autorizado", autorizado.getMessage());
    }
}
