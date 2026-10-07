package com.brasileirao.login.service;

import com.brasileirao.login.entity.Torcedor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TorcedorServiceTest {

    @Autowired
    private TorcedorService torcedorService;

    @Test
    @DisplayName("Deve autenticar com sucesso usando o NOME de usuário")
    void deveAutenticarComNomeESenhaCorreta() {
        Optional<Torcedor> resultado = torcedorService.autenticar("admin", "123456");

        assertTrue(resultado.isPresent(), "O login usando o nome admin deveria funcionar");
        assertEquals("admin", resultado.get().getNome());
    }

    @Test
    @DisplayName("Deve autenticar com sucesso usando o E-MAIL")
    void deveAutenticarComEmailESenhaCorreta() {
        Optional<Torcedor> resultado = torcedorService.autenticar("admin@teste.com", "123456");

        assertTrue(resultado.isPresent(), "O login usando o e-mail admin@teste.com deveria funcionar");
        assertEquals("admin@teste.com", resultado.get().getEmail());
    }

    @Test
    @DisplayName("Deve recusar o login quando a senha estiver errada")
    void deveFalharQuandoSenhaIncorreta() {
        Optional<Torcedor> resultado = torcedorService.autenticar("admin", "senha_errada");

        assertTrue(resultado.isEmpty(), "O login deve ser recusado com senha errada");
    }

    @Test
    @DisplayName("Deve recusar o login quando o usuário não existir")
    void deveFalharQuandoUsuarioNaoExiste() {
        Optional<Torcedor> resultado = torcedorService.autenticar("usuario_fantasma", "123456");

        assertTrue(resultado.isEmpty(), "O login deve ser recusado para usuario inexistente");
    }
}
