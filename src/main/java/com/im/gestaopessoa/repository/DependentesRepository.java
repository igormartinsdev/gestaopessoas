package com.im.gestaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.im.gestaopessoa.domain.Dependente;
import com.im.gestaopessoa.domain.Pessoa;

@Repository
public interface DependentesRepository extends JpaRepository<Dependente, Long> {

	@Query(value = "delete from Dependente d where d.pessoa.id = :pessoa")
	public Dependente deletaDependente(@Param("pessoa") Pessoa pessoa);
	
}
