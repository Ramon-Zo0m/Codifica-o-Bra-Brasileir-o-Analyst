package com.brasileirao.login.bean;

import com.brasileirao.login.entity.Torcedor;
import com.brasileirao.login.service.TorcedorService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Optional;

@Slf4j
@Getter
@Setter
@Named("loginBean")
@RequestScoped
@Component
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String senha;

    @Autowired
    private TorcedorService torcedorService;

    public String entrar() {
        log.info("LoginBean: Solicitando autenticacao para: {}", login);

        Optional<Torcedor> torcedorAutenticado = torcedorService.autenticar(login, senha);

        if (torcedorAutenticado.isPresent()) {
            log.info("LoginBean: Autenticado com sucesso. Redirecionando...");
            this.senha = null;
            return "sucesso?faces-redirect=true";
        } else {
            log.warn("LoginBean: Falha no login. Mostrando mensagem de erro.");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos.", null));
            return null;
        }
    }
}
