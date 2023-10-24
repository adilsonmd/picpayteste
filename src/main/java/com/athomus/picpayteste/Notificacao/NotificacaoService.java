package com.athomus.picpayteste.Notificacao;

import com.athomus.picpayteste.Servicos.Autorizacao;
import com.athomus.picpayteste.Transferencia.Transferencia;
import org.springframework.web.reactive.function.client.WebClient;

public class NotificacaoService {
    private final String URL = "http://o4d9z.mocklab.io";

    public NotificacaoData postNotificacao(NotificacaoData notificacao) {
        try {
            String URI = "/notify";

            WebClient
                    .create(URL)
                    .post()
                    .uri(URI)
                    .bodyValue(notificacao)
                    .retrieve()
                    .bodyToMono(NotificacaoData.class).block();

            notificacao.setEnviado(true);
            return notificacao;
        } catch (Exception ex) {
            notificacao.setEnviado(false);
            throw ex;
        }
    }
}
