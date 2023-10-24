package com.athomus.picpayteste.Usuario;

import com.athomus.picpayteste.Carteira.Carteira;
import jdk.jshell.spi.ExecutionControl;

import java.math.BigDecimal;

public class PessoaJuridica extends Pessoa implements Usuario, IRecebedor {

    private String CNPJ;

    public PessoaJuridica(String nomeCompleto, String cnpj, String email) {
        super();
        this.setNomeCompleto(nomeCompleto);
        this.setCNPJ(cnpj);
        this.setEmail(email);
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public void receber(BigDecimal valor) {
        this.getCarteira().adicionarValor(valor);
    }

}
