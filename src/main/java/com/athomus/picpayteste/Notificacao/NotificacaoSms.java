package com.athomus.picpayteste.Notificacao;

import com.athomus.picpayteste.Usuario.Usuario;

public class NotificacaoSms implements Notificacao {
    @Override
    public void enviar(Usuario destino, String mensagem) {
        // TODO
        System.out.println("Enviando mensagem para " + destino.getNomeCompleto());
    }
}
