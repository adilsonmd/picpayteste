package com.athomus.picpayteste;

import com.athomus.picpayteste.Notificacao.NotificacaoData;
import com.athomus.picpayteste.Notificacao.NotificacaoService;
import org.junit.jupiter.api.Test;

public class NotificacaoTeste {
    @Test
    public void notificacaoEnviada() {
        NotificacaoService service = new NotificacaoService();

        NotificacaoData data = new NotificacaoData();
        data.setMensagem("Gerando mensagem");
        data.setNomeDestinatario("Gerando mensagem");

        service.postNotificacao(data);
    }
}
