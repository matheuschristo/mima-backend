package br.senai.mima.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.mima.dto.user.LoginUserDTO;
import br.senai.mima.dto.user.UserDTO;
import br.senai.mima.projection.user.UserProjection;
import br.senai.mima.service.user.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> getUser(@RequestBody LoginUserDTO dto ) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByUser(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserProjection> getUser(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
}
