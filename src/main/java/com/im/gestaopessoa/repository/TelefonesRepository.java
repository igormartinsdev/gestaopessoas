package com.im.gestaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.im.gestaopessoa.domain.Pessoa;
import com.im.gestaopessoa.domain.Telefone;

@Repository
public interface TelefonesRepository extends JpaRepository<Telefone, Long> {

	@Query(value = "delete from Telefone t where t.pessoa = :pessoa")
	public void deletaTelefone(@Param("pessoa") Pessoa pessoa);
	
}
