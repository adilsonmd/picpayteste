package com.athomus.picpayteste.Notificacao;

import com.athomus.picpayteste.Usuario.Usuario;

public interface Notificacao {
    void enviar(Usuario destino, String mensagem);
}
