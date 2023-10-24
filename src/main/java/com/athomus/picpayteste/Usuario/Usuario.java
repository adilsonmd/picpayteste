package com.athomus.picpayteste.Usuario;

import com.athomus.picpayteste.Carteira.Carteira;

import java.math.BigDecimal;
import java.util.UUID;

public interface Usuario {
    String getId();
    String getNomeCompleto();
    String getEmail();
    double getSaldo();
}
