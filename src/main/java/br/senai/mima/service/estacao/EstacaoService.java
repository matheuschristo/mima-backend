package br.senai.mima.service.estacao;

import java.util.List;

import br.senai.mima.dto.estacao.EstacaoDTO;
import br.senai.mima.projection.estacao.EstacaoProjection;

public interface EstacaoService {
	
	EstacaoDTO save(EstacaoDTO dto);
	
	void update(EstacaoDTO dto, Long id);
	
	void delete(Long id);
	
	EstacaoProjection findById(Long id);
	
	List<EstacaoProjection> findAll();
	
	List<EstacaoProjection> findEstacaoByName(String name);
}
