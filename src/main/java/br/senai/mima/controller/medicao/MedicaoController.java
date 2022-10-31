package br.senai.mima.controller.medicao;

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

import br.senai.mima.dto.medicao.MedicaoDTO;
import br.senai.mima.projection.medicao.MedicaoProjection;
import br.senai.mima.service.medicao.MedicaoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/medicao")
public class MedicaoController {

	private final MedicaoService service;

	public MedicaoController(MedicaoService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<MedicaoDTO> addEstacao(@RequestBody MedicaoDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicaoProjection> getMedicao(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<MedicaoProjection>> getAllMedicao() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}
