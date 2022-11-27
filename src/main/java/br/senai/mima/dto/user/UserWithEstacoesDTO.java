package br.senai.mima.dto.user;

import java.util.List;

import br.senai.mima.projection.estacao.EstacaoProjection;

public record UserWithEstacoesDTO(List<EstacaoProjection> estacoes) {}
