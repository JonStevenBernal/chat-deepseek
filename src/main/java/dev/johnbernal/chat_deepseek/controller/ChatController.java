package dev.johnbernal.chat_deepseek.controller;

import dev.johnbernal.chat_deepseek.service.DeepSeekService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
public class ChatController {
    private final DeepSeekService deepSeekService;

    public ChatController(DeepSeekService deepSeekService) {
        this.deepSeekService = deepSeekService;
    }

    @GetMapping("/")
    public String showChat() {
        return "chat";
    }

    @PostMapping(value = "/api/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<String> chatStream(@RequestParam String prompt) {
        return deepSeekService.getStreamingResponse(prompt)
                .filter(chunk -> !chunk.contains("<think>"))
                .map(chunk -> {
                    // Limpieza optimizada para preservar palabras
                    return chunk
                            .replaceAll("</?think>", "")    // Elimina tags
                            .replaceAll("data:\\s*", "")    // Quita "data:"
                            .replaceAll("\\n|\\\\n|\\s{2,}", " ")  // Normaliza espacios
                            .replaceAll("(?<!\\s)\\s(?!\\s)|(?<=\\S) (?=\\S)", "") // Elimina espacios entre letras
                            .trim();
                })
                .concatWithValues("[DONE]");
    }
}
