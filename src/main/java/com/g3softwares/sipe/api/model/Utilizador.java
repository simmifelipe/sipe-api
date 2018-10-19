package com.g3softwares.sipe.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "utilizador")
public class Utilizador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	@Size(min = 3, max = 150)
	private String nome;

	@Column(name = "cpf_cnpj")
	private Long cpfCnpj;

	private Long ie;

	@Column(name = "inscricao_municipal")
	private Long inscricaoMunicipal;

	@Embedded
	private Endereco endereco;

	@Column(name = "quantidade_filiais")
	private Integer quantidadeFiliais;

	@Column(name = "acessos_permitidos")
	private Integer acessosPermitidos;

	@Column(name = "data_expiracao")
	private LocalDate dataExpiracao;

	private boolean ativo;

	@ManyToOne
	@JoinColumn(name = "codigo_cidade")
	private Cidade cidade;

	@ManyToMany
	@JoinTable(
			name = "utilizador_modulo", 
			joinColumns = @JoinColumn(name = "codigo_utilizador"), 
			inverseJoinColumns = @JoinColumn(name = "codigo_modulo"))
	private List<Modulo> modulos;
	
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome; 
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Long getIe() {
		return ie;
	}

	public void setIe(Long iE) {
		ie = iE;
	}

	public Long getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(Long inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getQuantidadeFiliais() {
		return quantidadeFiliais;
	}

	public void setQuantidadeFiliais(Integer quantidadeFiliais) {
		this.quantidadeFiliais = quantidadeFiliais;
	}

	public Integer getAcessosPermitidos() {
		return acessosPermitidos;
	}

	public void setAcessosPermitidos(Integer acessosPermitidos) {
		this.acessosPermitidos = acessosPermitidos;
	}

	public LocalDate getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(LocalDate dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilizador other = (Utilizador) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
