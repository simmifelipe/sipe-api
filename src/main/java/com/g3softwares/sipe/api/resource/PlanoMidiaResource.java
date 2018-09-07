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
import com.g3softwares.sipe.api.model.PlanoMidia;
import com.g3softwares.sipe.api.repository.PlanoMidiaRepository;
import com.g3softwares.sipe.api.service.PlanoMidiaService;

@RestController
@RequestMapping("/planos-midia")
public class PlanoMidiaResource {

	@Autowired
	private PlanoMidiaRepository planoMidiaRepository;

	@Autowired
	private PlanoMidiaService planoMidiaService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<PlanoMidia> listar() {
		return this.planoMidiaRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PlanoMidia> criar(@Valid @RequestBody PlanoMidia planoMidia, HttpServletResponse response) {

		PlanoMidia planoMidiaSalvo = planoMidiaRepository.save(planoMidia);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, planoMidiaSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(planoMidiaSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<PlanoMidia> buscarPorCodigo(@PathVariable Long codigo) {
		PlanoMidia planoMidia = planoMidiaRepository.findOne(codigo);
		return planoMidia != null ? ResponseEntity.ok(planoMidia) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		planoMidiaRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<PlanoMidia> atualizar(@PathVariable Long codigo, @Valid @RequestBody PlanoMidia planoMidia) {
		PlanoMidia planoMidiaSalvo = planoMidiaService.atualizar(codigo, planoMidia);
		return ResponseEntity.ok(planoMidiaSalvo);
	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		planoMidiaService.atualizarPropriedadeAtivo(codigo, ativo);
	}

}
