package com.g3softwares.sipe.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.g3softwares.sipe.api.event.RecursoCriadoEvent;
import com.g3softwares.sipe.api.model.Modulo;
import com.g3softwares.sipe.api.repository.ModuloRepository;
import com.g3softwares.sipe.api.service.ModuloService;

@RestController
@RequestMapping("/modulos")
public class ModuloResource {

	@Autowired
	private ModuloRepository moduloRepository;

	@Autowired
	private ModuloService moduloService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Modulo> listar() {
		return this.moduloRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Modulo> criar(@Valid @RequestBody Modulo modulo, HttpServletResponse response) {

		Modulo moduloSalvo = moduloRepository.save(modulo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, moduloSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(moduloSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Modulo> buscarPorCodigo(@PathVariable Long codigo) {
		Modulo modulo = moduloRepository.findOne(codigo);
		return modulo != null ? ResponseEntity.ok(modulo) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		moduloRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Modulo> atualizar(@PathVariable Long codigo, @Valid @RequestBody Modulo modulo) {
		Modulo moduloSalvo = moduloService.atualizar(codigo, modulo);
		return ResponseEntity.ok(moduloSalvo);
	}

}
