package br.senai.mima.entity.estacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senai.mima.entity.medicao.Medicao;

@Entity
@Table(name = "tb_estacao")
public class Estacao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacao")
	private Long id;
	
	@Column(name = "nome_estacao")
	private String nome;

	@Column(name = "descricao_estacao", nullable = false)
	private String descricao;
	
	@Column(name = "localizacao_estacao")
	private String localizacao;
	
	@Column(name = "nmresponsavel_estacao")
	private String responsavel;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Medicao> medicoes = new ArrayList<>();

	public Estacao() {}
	
	public Estacao(Long id, String nome,String descricao, String localizacao, String responsavel) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.localizacao = localizacao;
		this.responsavel = responsavel;
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
    
	public String getDescricao() {
    		return descricao;
	}
	
	public void setDescricao(String descricao) {                                 
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public List<Medicao> getMedicoes() {
		return medicoes;
	}
}
