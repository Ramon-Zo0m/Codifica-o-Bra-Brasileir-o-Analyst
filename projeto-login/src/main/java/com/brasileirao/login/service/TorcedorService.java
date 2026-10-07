package com.brasileirao.login.service;

import com.brasileirao.login.entity.Torcedor;
import com.brasileirao.login.repository.TorcedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TorcedorService {

    @Autowired
    private TorcedorRepository torcedorRepository;

    public Optional<Torcedor> autenticar(String login, String senha) {
        log.info("Tentativa de login para: {}", login);

        if (login == null || login.trim().isEmpty() || senha == null || senha.isEmpty()) {
            log.warn("Login ou senha vazios informados.");
            return Optional.empty();
        }

        try {
            String loginLimpo = login.trim();

            Optional<Torcedor> torcedorOpt = torcedorRepository.findByNomeOrEmail(loginLimpo, loginLimpo);

            if (torcedorOpt.isEmpty()) {
                log.warn("Usuario nao encontrado no banco: {}", loginLimpo);
                return Optional.empty();
            }

            Torcedor torcedor = torcedorOpt.get();

            if (!torcedor.getSenha().equals(senha)) {
                log.warn("Senha incorreta informada para o usuario: {}", loginLimpo);
                return Optional.empty();
            }

            log.info("Login realizado com sucesso para o usuario: {}", torcedor.getNome());
            return Optional.of(torcedor);

        } catch (Exception e) {
            log.error("Erro durante autenticacao para: {}", login, e);
            return Optional.empty();
        }
    }

    public Torcedor salvar(Torcedor torcedor) {
        log.info("Salvando torcedor: {}", torcedor.getNome());
        return torcedorRepository.save(torcedor);
    }

    public Optional<Torcedor> buscarPorId(Long id) {
        return torcedorRepository.findById(id);
    }
}
