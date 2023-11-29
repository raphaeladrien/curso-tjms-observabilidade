package br.com.tjms.helloobservabilidade.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("hello")
public class HelloController {

    private final RestTemplate restTemplate;

    public HelloController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("https://httpbin.org/post",
            "Hello, Cloud!", String.class);
        return responseEntity;
    }
}
