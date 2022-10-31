package br.senai.mima.service.medicao;

import java.util.List;

import br.senai.mima.dto.medicao.MedicaoDTO;
import br.senai.mima.projection.medicao.MedicaoProjection;

public interface MedicaoService {
	
	MedicaoDTO save(MedicaoDTO dto);
	
	void update(MedicaoDTO dto, Long id);
	
	void delete(Long id);

	MedicaoProjection findById(Long id);
	
	List<MedicaoProjection> findAll();
}
