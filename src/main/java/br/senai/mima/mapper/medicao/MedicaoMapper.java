package br.senai.mima.mapper.medicao;

import org.springframework.stereotype.Service;

import br.senai.mima.dto.medicao.MedicaoDTO;
import br.senai.mima.entity.medicao.Medicao;

@Service
public class MedicaoMapper {
	
	public MedicaoDTO toDTO(Medicao medicao) {
		return new MedicaoDTO(medicao.getData(), medicao.getEstacao().getId(), medicao.getPressao(), medicao.getTemperatura(), medicao.getUmidade());
	}

}
