package com.im.gestaopessoa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.im.gestaopessoa.domain.Dependente;
import com.im.gestaopessoa.domain.Endereco;
import com.im.gestaopessoa.domain.Pessoa;
import com.im.gestaopessoa.domain.Telefone;
import com.im.gestaopessoa.service.PessoasService;
import com.im.gestaopessoa.service.exceptions.PessoaNaoEncontradaException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pessoas")
@Api(value = "API REST Pessoas")
@CrossOrigin(origins = "*")
public class PessoasResources {

	@Autowired
	private PessoasService pessoasService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Retorna uma lista de pessoas")
	public ResponseEntity<List<Pessoa>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(pessoasService.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Cadastra uma pessoa")
	public ResponseEntity<Void> salvar(@RequestBody Pessoa pessoa) {
		pessoa = pessoasService.salvar(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Retorna consulta de uma pessoa pelo id")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {		
		Pessoa pessoa = null;
		
		try {
			pessoa = pessoasService.buscar(id);
		} catch (PessoaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}		
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoa);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Exclui a pessoa e todas as suas associações")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		try {
			pessoasService.deletar(id);
		} catch (PessoaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}		
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Atualiza o cadastro de uma pessoa")
	public ResponseEntity<Void> atualizar(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		pessoa.setId(id);
		
		try {
			pessoasService.atualizar(pessoa);
		} catch (PessoaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/dependentes", method = RequestMethod.POST)
	@ApiOperation(value = "Adiciona dependentes a partir de um id de uma pessoa")
	public ResponseEntity<Void> adicionarDependente(@PathVariable("id") Long idPessoa, @RequestBody Dependente dependente) {
		try {
			pessoasService.salvarDependente(idPessoa, dependente);
		} catch (PessoaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/telefones", method = RequestMethod.POST)
	@ApiOperation(value = "Adiciona telefones a partir de um id de uma pessoa")
	public ResponseEntity<Void> adicionarTelefone(@PathVariable("id") Long idPessoa, @RequestBody Telefone telefone){
		try {
			pessoasService.salvarTelefone(idPessoa, telefone);
		} catch (PessoaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/enderecos", method = RequestMethod.POST)
	@ApiOperation(value = "Adiciona endereços a partir de um id de uma pessoa")
	public ResponseEntity<Void> adicionarEndereco(@PathVariable("id") Long idPessoa, @RequestBody Endereco endereco){
		try {
			pessoasService.salvarEndereco(idPessoa, endereco);
		} catch (PessoaNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}