package br.senai.mima.projection.medicao;

import java.time.LocalDate;

public interface MedicaoProjection {

	LocalDate getData();
			
	Double getPressao();
	
	Double getTemperatura();
	
	Integer getUmidade();
}
