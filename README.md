# Brasileirão Analyst — Módulo de Autenticação (Login)

Projeto acadêmico de autenticação de usuários desenvolvido em **Java Spring Boot + JSF (Jakarta Faces)**, estruturado em arquitetura em camadas para a disciplina de Laboratório de Engenharia de Software 1 (LG1).

---

## 📌 Sobre o Projeto

Este módulo implementa a funcionalidade essencial de **login de torcedores**:
- **Interface Web Simples em JSF**: Formulário contendo apenas identificador (`login`), `senha` e o botão `[ Entrar ]`.
- **Autenticação Flexível**: O usuário pode acessar utilizando seu **nome de usuário** (`admin`) ou seu **e-mail** (`admin@teste.com`).
- **Feedback ao Usuário**: Mensagem padronizada `Usuário ou senha inválidos.` em caso de erro, permanecendo na mesma tela.
- **Redirecionamento**: Encaminhamento automático para a tela de confirmação (`sucesso.xhtml`) em caso de sucesso.
- **Banco de Dados MySQL**: Conexão com banco de dados MySQL via XAMPP (`brasileirao_db`), com mapeamento automático de entidades via Hibernate.
- **Segurança nos Logs**: Registro de eventos do fluxo com `@Slf4j` sem jamais expor as senhas nos logs.

---

## 🏛️ Arquitetura em Camadas

```
+-------------------------------------------------------------+
|                      Visualização (JSF)                     |
|           login.xhtml  --->  sucesso.xhtml                  |
+-------------------------------------------------------------+
                              |
                              v
+-------------------------------------------------------------+
|                     Controle (JSF Bean)                     |
|            LoginBean (@Named, @RequestScoped)               |
+-------------------------------------------------------------+
                              |
                              v
+-------------------------------------------------------------+
|                     Negócio (Service)                       |
|                 TorcedorService (@Service)                  |
+-------------------------------------------------------------+
                              |
                              v
+-------------------------------------------------------------+
|                   Persistência (Repository)                 |
|             TorcedorRepository (Spring Data JPA)            |
+-------------------------------------------------------------+
                              |
                              v
+-------------------------------------------------------------+
|                    Entidade de Domínio                      |
|             Torcedor (@Entity, Bean Validation)             |
+-------------------------------------------------------------+
                              |
                              v
+-------------------------------------------------------------+
|                       Banco de Dados                        |
|                  MySQL (XAMPP - Porta 3306)                 |
+-------------------------------------------------------------+
```

---

## 🛠️ Tecnologias Utilizadas

- **Java 17 / 21+**
- **Spring Boot 3.3.4**
- **JSF / Jakarta Faces 4.0** (Mojarra via JoinFaces 5.3.8)
- **Spring Data JPA & Hibernate**
- **Jakarta Bean Validation**
- **MySQL Connector/J (XAMPP)**
- **Lombok**
- **Maven Wrapper**

---

## 🚀 Como Executar

### Pré-requisito:
- Iniciar o serviço do **MySQL** no painel de controle do **XAMPP** (Porta padrão: `3306`).

### 1. Entrar na pasta do projeto:
```bash
cd projeto-login
```

### 2. Rodar os testes automatizados:
```bash
./mvnw test
```
*(No Windows: `.\mvnw.cmd test`)*

### 3. Iniciar a aplicação:
```bash
./mvnw spring-boot:run
```
*(No Windows: `.\mvnw.cmd spring-boot:run`)*

### 4. Acessar no navegador:
- **Tela de Login**: [http://localhost:8080/login.xhtml](http://localhost:8080/login.xhtml)
- **Gerenciador de Banco (phpMyAdmin)**: [http://localhost/phpmyadmin](http://localhost/phpmyadmin)
  - Banco: `brasileirao_db`
  - Tabela: `torcedores`

---

## 👤 Credenciais de Teste

| Campo | Valor |
| :--- | :--- |
| **Nome de usuário** | `admin` |
| **E-mail** | `admin@teste.com` |
| **Senha** | `123456` |

*O login funciona tanto informando `admin` quanto `admin@teste.com` com a senha `123456`.*
