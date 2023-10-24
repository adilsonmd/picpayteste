package com.athomus.picpayteste.Usuario;

import java.math.BigDecimal;

public interface IPagador {
    void pagar(BigDecimal valor) throws Exception;
}
