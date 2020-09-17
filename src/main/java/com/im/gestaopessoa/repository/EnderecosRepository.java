package com.im.gestaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.im.gestaopessoa.domain.Endereco;
import com.im.gestaopessoa.domain.Pessoa;

@Repository
public interface EnderecosRepository extends JpaRepository<Endereco, Long> {

	@Query(value = "delete from Endereco e where e.pessoa = :pessoa")
	public void deletaEndereco(@Param("pessoa") Pessoa pessoa);
	
}
