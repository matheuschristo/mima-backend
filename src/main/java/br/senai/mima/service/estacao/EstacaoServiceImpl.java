package br.senai.mima.service.estacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senai.mima.dto.estacao.EstacaoDTO;
import br.senai.mima.dto.estacao.EstacaoRegisterDTO;
import br.senai.mima.entity.estacao.Estacao;
import br.senai.mima.entity.user.User;
import br.senai.mima.exception.estacao.EstacaoNotFoundException;
import br.senai.mima.exception.user.UserNotFoundException;
import br.senai.mima.mapper.estacao.EstacaoMapper;
import br.senai.mima.projection.estacao.EstacaoProjection;
import br.senai.mima.repository.estacao.EstacaoRepository;
import br.senai.mima.repository.user.UserRepository;

@Service
public class EstacaoServiceImpl implements EstacaoService{

	private final EstacaoRepository repository;
	private final EstacaoMapper mapper;
	private final UserRepository userRepository;
	
	public EstacaoServiceImpl(EstacaoRepository repository, EstacaoMapper mapper, UserRepository userRepository) {
		this.userRepository = userRepository; 
		this.repository = repository;
		this.mapper = mapper;
	}

	public EstacaoRegisterDTO save(EstacaoDTO dto) {
		
		User user = userRepository.findById(dto.idUser()).orElseThrow(() -> new UserNotFoundException("User "+ dto.idUser() +" was not found."));
		
		Estacao estacao = new Estacao(dto.id(), user, dto.nome(), dto.descricao(), dto.localizacao(), dto.responsavel());
		Estacao estacaoSaved = repository.save(estacao);
		
		return mapper.toDTO(estacaoSaved);
	}

	public void update(EstacaoDTO dto, Long id) {
		
	}

	public void delete(Long id) {
		
	}

	public EstacaoProjection findById(Long id) {
		
		EstacaoProjection estacao = repository.findEstacaoById(id).orElseThrow(() -> new EstacaoNotFoundException("Estacao "+ id +" was not found"));
		return estacao;
	}

	public List<EstacaoProjection> findAll() {
		return repository.findEstacoes();
	}

	public List<EstacaoProjection> findEstacaoByName(String name) {
		return repository.findEstacaoByNomeContainsIgnoreCase(name);
	}
	
	

	
}
