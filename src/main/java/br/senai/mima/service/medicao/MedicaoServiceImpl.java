package br.senai.mima.service.medicao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senai.mima.dto.medicao.MedicaoDTO;
import br.senai.mima.entity.estacao.Estacao;
import br.senai.mima.entity.medicao.Medicao;
import br.senai.mima.exception.estacao.EstacaoNotFoundException;
import br.senai.mima.exception.medicao.MedicaoNotFoundException;
import br.senai.mima.mapper.medicao.MedicaoMapper;
import br.senai.mima.projection.medicao.MedicaoProjection;
import br.senai.mima.repository.estacao.EstacaoRepository;
import br.senai.mima.repository.medicao.MedicaoRepository;

@Service
public class MedicaoServiceImpl implements MedicaoService{

	private final MedicaoRepository repository;
	private final MedicaoMapper mapper;
	private final EstacaoRepository estacaoRepository;
	
	public MedicaoServiceImpl(MedicaoRepository repository, EstacaoRepository estacaoRepository, MedicaoMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.estacaoRepository = estacaoRepository;
	}

	public MedicaoDTO save(MedicaoDTO dto) {
		
		Estacao estacao = estacaoRepository.findById(dto.idEstacao()).orElseThrow(() -> new EstacaoNotFoundException("Estacao "+ dto.idEstacao() +" was not found."));
		
		Medicao medicao = new Medicao(dto.data(), estacao, dto.pressao(), dto.temperatura(), dto.umidade());
		Medicao medicaoSaved = repository.save(medicao);
		
		return mapper.toDTO(medicaoSaved);
	}

	public void update(MedicaoDTO dto, Long id) {
		
	}

	public void delete(Long id) {
		
	}

	public MedicaoProjection findById(Long id) {
		
		MedicaoProjection medicao = repository.findMedicaoById(id).orElseThrow(() -> new MedicaoNotFoundException("Medicao "+ id +" was not found"));
		return medicao;
	}

	public List<MedicaoProjection> findAll() {
		return null;
	}
}
