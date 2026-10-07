package com.brasileirao.login.repository;

import com.brasileirao.login.entity.Torcedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TorcedorRepository extends JpaRepository<Torcedor, Long> {

    Optional<Torcedor> findByNomeOrEmail(String nome, String email);

    Optional<Torcedor> findByNome(String nome);

    Optional<Torcedor> findByEmail(String email);
}
