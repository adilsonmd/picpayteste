package com.athomus.picpayteste.Usuario;

import java.math.BigDecimal;

public class PessoaFisica extends Pessoa implements Usuario, IPagador, IRecebedor {
    private String CPF;

    public PessoaFisica(String nomeCompleto, String CPF, String email) {
        super();
        this.setNomeCompleto(nomeCompleto);
        this.setEmail(email);
        this.setCPF(CPF);
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void receber(BigDecimal valor) {
        this.getCarteira().adicionarValor(valor);
    }
    public void pagar(BigDecimal valor) throws Exception {
        this.getCarteira().retirarValor(valor);
    }
}
