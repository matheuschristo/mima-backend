package br.senai.mima.projection.estacao;

import java.util.List;

import br.senai.mima.projection.medicao.MedicaoProjection;

public interface EstacaoWithMedicaoProjection {

	Long getId();
	
	String getNome();
	
	String getDescricao();

	String getLocalizacao();
	
	String getResponsavel();
	
	List<MedicaoProjection> getMedicoes();
}
