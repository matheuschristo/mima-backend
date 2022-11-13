package br.senai.mima.dto.medicao;

import java.time.LocalDate;

public record MedicaoDTO(Long id, LocalDate data, Long idEstacao, Double pressao, Double temperatura, Integer umidade) {}
