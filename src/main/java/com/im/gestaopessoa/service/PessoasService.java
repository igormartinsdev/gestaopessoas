package com.im.gestaopessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.im.gestaopessoa.domain.Dependente;
import com.im.gestaopessoa.domain.Endereco;
import com.im.gestaopessoa.domain.Pessoa;
import com.im.gestaopessoa.domain.Telefone;
import com.im.gestaopessoa.repository.DependentesRepository;
import com.im.gestaopessoa.repository.EnderecosRepository;
import com.im.gestaopessoa.repository.PessoasRepository;
import com.im.gestaopessoa.repository.TelefonesRepository;
import com.im.gestaopessoa.service.exceptions.PessoaNaoEncontradaException;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	@Autowired
	private DependentesRepository dependentesRepository;
	
	@Autowired
	private TelefonesRepository telefonesRepository;
	
	@Autowired
	private EnderecosRepository enderecosRepository;
	
	public List<Pessoa> listar(){
		return pessoasRepository.findAll();
	}
	
	public Pessoa buscar(Long id) {
		Optional<Pessoa> pessoa = pessoasRepository.findById(id);
		
		if(pessoa.isEmpty()) {
			throw new PessoaNaoEncontradaException("A pessoa não pode ser encontrada!");
		}
		
		return pessoa.get();
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		pessoa.setId(null);
		return pessoasRepository.save(pessoa);		
	}
	
	public void deletar(Long id) {
		try {
			Pessoa pessoa = buscar(id);
			deletaTodasAssociacoes(pessoa);
			pessoasRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new PessoaNaoEncontradaException("A pessoa não pode ser encontrada!");
		}
	}
	
	public void atualizar(Pessoa pessoa) {
		verificarExistencia(pessoa);
		pessoasRepository.save(pessoa);
	}
	
	private void verificarExistencia(Pessoa pessoa) {
		buscar(pessoa.getId());
	}
	
	public Dependente salvarDependente(Long idPessoa, Dependente dependente) {
		
		Pessoa pessoa = buscar(idPessoa);
		dependente.setPessoa(pessoa);
		
		return dependentesRepository.save(dependente);
	}
	
	public Telefone salvarTelefone(Long idPessoa, Telefone telefone) {
		Pessoa pessoa = buscar(idPessoa);
		telefone.setPessoa(pessoa);
		
		return telefonesRepository.save(telefone);
	}
	
	public Endereco salvarEndereco(Long idPessoa, Endereco endereco) {
		Pessoa pessoa = buscar(idPessoa);
		endereco.setPessoa(pessoa);
		
		return enderecosRepository.save(endereco);
	}
	
	private void deletaTodasAssociacoes(Pessoa pessoa) {
		
		dependentesRepository.deletaDependente(pessoa);
		telefonesRepository.deletaTelefone(pessoa);
		enderecosRepository.deletaEndereco(pessoa);
		
	}

}
