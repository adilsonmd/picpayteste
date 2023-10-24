package com.athomus.picpayteste.Depositos;

import com.athomus.picpayteste.Usuario.IRecebedor;
import com.athomus.picpayteste.Usuario.Usuario;

import java.math.BigDecimal;

public class DepositoController {
    public void depositar(IRecebedor destino, BigDecimal valor) throws Exception {
        // TODO segurança
        destino.receber(valor);
    }
}
