package dev.johnbernal.chat_deepseek.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DeepSeekService {

    private final ChatClient chatClient;

    public DeepSeekService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public Flux<String> getStreamingResponse(String prompt) {
        // Configuración compatible con Spring AI 1.0+
        OllamaOptions options = OllamaOptions.builder()
                .numPredict(200)
                .numCtx(4096)
                .temperature(0.8)
                .build();

        Flux<String> response = chatClient.prompt()
                .user(prompt)
                .options(options)         // Usa las opciones actualizadas
                .stream()
                .content();

        return response;
    }
}
