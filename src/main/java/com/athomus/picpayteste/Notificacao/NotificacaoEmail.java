package com.athomus.picpayteste.Notificacao;

import com.athomus.picpayteste.Usuario.Usuario;

public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(Usuario destino, String mensagem) {
        NotificacaoData data = new NotificacaoData();
        data.setNomeDestinatario(destino.getNomeCompleto());

        System.out.println("Enviando email para " + destino.getEmail());
    }
}
