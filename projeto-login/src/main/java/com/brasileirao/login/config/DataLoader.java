package com.brasileirao.login.config;

import com.brasileirao.login.entity.Torcedor;
import com.brasileirao.login.repository.TorcedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner carregarDadosIniciais(TorcedorRepository torcedorRepository) {
        return args -> {
            if (torcedorRepository.findByNome("admin").isEmpty()) {
                Torcedor admin = new Torcedor("admin", "admin@teste.com", "123456");
                torcedorRepository.save(admin);
                log.info("Usuario de teste criado: admin / admin@teste.com / 123456");
            } else {
                log.info("Usuario de teste 'admin' ja esta presente no banco.");
            }
        };
    }
}
