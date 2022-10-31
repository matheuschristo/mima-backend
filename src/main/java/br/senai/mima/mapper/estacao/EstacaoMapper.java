package br.senai.mima.mapper.estacao;

import org.springframework.stereotype.Service;

import br.senai.mima.dto.estacao.EstacaoDTO;
import br.senai.mima.entity.estacao.Estacao;

@Service
public class EstacaoMapper {

	public EstacaoDTO toDTO(Estacao estacao) {
		return new EstacaoDTO(estacao.getId(), estacao.getNome(), estacao.getDescricao(), estacao.getLocalizacao(), estacao.getResponsavel());
	}
	
	public Estacao toEntity(EstacaoDTO dto) {
		return new Estacao(dto.id(), dto.nome(), dto.descricao(), dto.localizacao(), dto.responsavel());
	}
}
