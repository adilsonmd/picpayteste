package com.athomus.picpayteste.Transferencia;

import com.athomus.picpayteste.Usuario.*;

import java.math.BigDecimal;


public class Transferencia {
    private IRecebedor recebedor;
    private IPagador pagador;
    private BigDecimal valor;

    public static Transferencia mock() {
        Transferencia tr = new Transferencia();

        IPagador u1 = new PessoaFisica("Adilson Alves Mattos", "48474652880", "adilson_am@email.teste");
        IRecebedor u2 = new PessoaJuridica("PicPay Corp", "46650169198528", "usuario2@email.teste");

        tr.setPagador(u1);
        tr.setRecebedor(u2);
        tr.setValor("100.0");

        return tr;
    }

    public IRecebedor getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(IRecebedor recebedor) {
        this.recebedor = recebedor;
    }

    public IPagador getPagador() {
        return pagador;
    }

    public void setPagador(IPagador pagador) {
        this.pagador = pagador;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(String valor) {
        try {
            BigDecimal bd = new BigDecimal(valor);
            if (bd.signum() == -1) {
                throw new IllegalArgumentException("Valor não pode ser negativo");
            }
            this.valor = bd;
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Formato incorreto de valor");
        }
    }
}
