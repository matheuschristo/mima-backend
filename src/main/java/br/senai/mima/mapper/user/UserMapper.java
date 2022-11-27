package br.senai.mima.mapper.user;

import org.springframework.stereotype.Service;

import br.senai.mima.dto.user.UserDTO;
import br.senai.mima.entity.user.User;

@Service
public class UserMapper {

	public UserDTO toDTO(User user) {
		return new UserDTO(user.getId(), user.getNome(), user.getSobrename(), user.getEmail(), user.getSenha(), user.getPhone());
	}
}
