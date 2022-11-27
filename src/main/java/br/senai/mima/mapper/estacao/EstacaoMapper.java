package br.senai.mima.mapper.estacao;

import org.springframework.stereotype.Service;

import br.senai.mima.dto.estacao.EstacaoDTO;
import br.senai.mima.dto.estacao.EstacaoRegisterDTO;
import br.senai.mima.entity.estacao.Estacao;
import br.senai.mima.entity.user.User;
import br.senai.mima.exception.user.UserNotFoundException;
import br.senai.mima.repository.user.UserRepository;

@Service
public class EstacaoMapper {
	
	private final UserRepository userRepository;
	
	public EstacaoMapper(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public EstacaoRegisterDTO toDTO(Estacao estacao) {
		return new EstacaoRegisterDTO(estacao.getUser().getId(), estacao.getNome(), estacao.getDescricao(), estacao.getLocalizacao(), estacao.getResponsavel());
	}
	
	public Estacao toEntity(EstacaoDTO dto) {
		User user = userRepository.findById(dto.idUser()).orElseThrow(() -> new UserNotFoundException("User "+ dto.idUser() +" was not found."));
		
		return new Estacao(dto.id(), user,dto.nome(), dto.descricao(), dto.localizacao(), dto.responsavel());
	}
}
