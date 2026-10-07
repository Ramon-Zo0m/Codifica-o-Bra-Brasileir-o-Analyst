package com.brasileirao.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        log.info("Iniciando a aplicacao de autenticacao...");
        SpringApplication.run(Application.class, args);
        log.info("Aplicacao pronta! Acesse: http://localhost:8080/login.xhtml");
    }
}
