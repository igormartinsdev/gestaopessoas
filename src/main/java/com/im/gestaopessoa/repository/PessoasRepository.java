package com.im.gestaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.im.gestaopessoa.domain.Pessoa;

public interface PessoasRepository extends JpaRepository<Pessoa, Long> {

}
