package br.senai.mima.service.user;

import org.springframework.stereotype.Service;

import br.senai.mima.dto.user.LoginUserDTO;
import br.senai.mima.dto.user.UserDTO;
import br.senai.mima.entity.user.User;
import br.senai.mima.exception.user.UserIncorrectPasswordException;
import br.senai.mima.exception.user.UserNotFoundException;
import br.senai.mima.mapper.user.UserMapper;
import br.senai.mima.projection.user.UserProjection;
import br.senai.mima.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	private final UserMapper mapper;
	
	public UserServiceImpl(UserRepository repository, UserMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public UserDTO save(UserDTO dto) {

		User user = new User(dto.id(), dto.nome(), dto.sobrenome(), dto.email(), dto.senha(), dto.phone());
		User userSaved = repository.save(user);
		
		return mapper.toDTO(userSaved);
	}

	public void delete(Long id) {
	}

	public void update(Long id) {
		
	}

	public UserProjection findById(Long id) {

		UserProjection user = repository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User "+ id +" was not found"));
		
		return user;
	}

	public UserDTO findByUser(LoginUserDTO dto) {
		
		if(!repository.existsByEmail(dto.email())) {
			throw new UserNotFoundException("Email " + dto.email() + " was not found");
		}
		
		UserProjection user = repository.findUserByEmail(dto.email()).orElseThrow(() -> new UserNotFoundException("User with email "+ dto.email() +" was not found"));
		
		if(!dto.senha().equals(user.getSenha())) {
			throw new UserIncorrectPasswordException("Incorrect password");
		}
		
		return new UserDTO(user.getId(), user.getNome(), user.getSobrename(), user.getEmail(), user.getSenha(), user.getPhone());
	}

}
