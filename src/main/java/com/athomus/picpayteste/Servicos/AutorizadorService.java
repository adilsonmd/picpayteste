package com.athomus.picpayteste.Servicos;

import com.athomus.picpayteste.Transferencia.Transferencia;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

public class AutorizadorService {
    private static final String URL = "https://run.mocky.io";
    public static boolean isAutorizado(Transferencia transferencia) throws Exception {
        Autorizacao response = postAutorizacao(transferencia);

        if (response == null) {
            throw new Exception("Falha na comunicação com a API");
        }

        if (StringUtils.isEmpty(response.getMessage())) return false;

        if (!response.getMessage().equalsIgnoreCase("Autorizado")) return false;

        return true;
    }


    public static Autorizacao postAutorizacao(Transferencia transferencia) {
        String URI = "/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6";

        Autorizacao autorizacaoResponse = WebClient
                .create(URL)
                .post()
                .uri(URI)
                .bodyValue(transferencia)
                .retrieve()
                .bodyToMono(Autorizacao.class).block();

        System.out.println("Resposta: " + autorizacaoResponse.getMessage());

        return autorizacaoResponse;
    }
}
