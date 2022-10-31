package br.senai.mima.projection.medicao;

import java.time.LocalDate;

import br.senai.mima.entity.estacao.Estacao;

public interface MedicaoProjection {

	LocalDate getData();
	
	Estacao getEstacao();
	
	Double getPressao();
	
	Double getTemperatura();
	
	Integer getUmidade();
}
