package br.senai.mima.controller.estacao;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.mima.dto.estacao.EstacaoDTO;
import br.senai.mima.projection.estacao.EstacaoProjection;
import br.senai.mima.service.estacao.EstacaoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/estacao")
public class EstacaoController {

	private final EstacaoService service;

	public EstacaoController(EstacaoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<EstacaoDTO> addEstacao(@RequestBody EstacaoDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstacaoProjection> getEstacao(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EstacaoProjection>> getAllEstacao() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/search-name/{name}")
	public ResponseEntity<List<EstacaoProjection>> getEstacaoByName(@PathVariable(value = "name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findEstacaoByName(name));
	}
	
	
}
