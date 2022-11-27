package br.senai.mima.service.user;

import br.senai.mima.dto.user.LoginUserDTO;
import br.senai.mima.dto.user.UserDTO;
import br.senai.mima.projection.user.UserProjection;

public interface UserService {

	UserDTO save(UserDTO dto);
	
	void delete(Long id);
	
	void update(Long id);
	
	UserProjection findById(Long id);
	
	UserDTO findByUser(LoginUserDTO dto);
}
