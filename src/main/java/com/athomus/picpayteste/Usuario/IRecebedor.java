package com.athomus.picpayteste.Usuario;

import java.math.BigDecimal;

public interface IRecebedor {
    void receber(BigDecimal valor) throws Exception;
}
