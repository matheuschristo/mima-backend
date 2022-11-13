package br.senai.mima.entity.medicao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senai.mima.entity.estacao.Estacao;

@Entity
@Table(name = "tb_medicao")
public class Medicao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicao")
	private Long id;
	
	@Column(name = "data_medicao")
	private LocalDate data;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estacao")
	private Estacao estacao;
	
	@Column(name = "pressao_medicao")
	private Double pressao;
	
	@Column(name = "temperatura_medicao")
	private Double temperatura;
	
	@Column(name = "umidade_medicao")
	private Integer umidade;

	public Medicao(Long id, LocalDate data, Estacao estacao, Double pressao, Double temperatura, Integer umidade) {
		this.id = id;
		this.data = data;
		this.estacao = estacao;
		this.pressao = pressao;
		this.temperatura = temperatura;
		this.umidade = umidade;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public Double getPressao() {
		return pressao;
	}

	public void setPressao(Double pressao) {
		this.pressao = pressao;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Integer getUmidade() {
		return umidade;
	}

	public void setUmidade(Integer umidade) {
		this.umidade = umidade;
	}
	
	
}
