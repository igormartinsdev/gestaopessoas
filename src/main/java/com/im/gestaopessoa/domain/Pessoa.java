package com.im.gestaopessoa.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Pessoa {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private String cadastroUnico;
	
	@JsonInclude(Include.NON_NULL)
	private String profissao;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal salario;
	
	@JsonInclude(Include.NON_NULL)
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> listaEndereco;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Dependente> listaDependentes;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Telefone> listaTelefones;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCadastroUnico() {
		return cadastroUnico;
	}

	public void setCadastroUnico(String cadastroUnico) {
		this.cadastroUnico = cadastroUnico;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco(List<Endereco> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}

	public List<Dependente> getListaDependentes() {
		return listaDependentes;
	}

	public void setListaDependentes(List<Dependente> listaDependentes) {
		this.listaDependentes = listaDependentes;
	}

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}
	
}
