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
import com.g3softwares.sipe.api.model.TipoParticipante;
import com.g3softwares.sipe.api.repository.TipoParticipanteRepository;
import com.g3softwares.sipe.api.service.TipoParticipanteService;

@RestController
@RequestMapping("/tiposparticipantes")
public class TipoParticipanteResource {

	@Autowired
	private TipoParticipanteRepository tipoParticipanteRepository;

	@Autowired
	private TipoParticipanteService tipoParticipanteService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@RequestMapping
	public List<TipoParticipante> listar() {
		return this.tipoParticipanteRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<TipoParticipante> criar(@Valid @RequestBody TipoParticipante tipoParticipante,
			HttpServletResponse response) {

		TipoParticipante tipoParticipanteSalvo = this.tipoParticipanteRepository.save(tipoParticipante);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoParticipanteSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoParticipanteSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<TipoParticipante> buscarPorCodigo(@PathVariable Long codigo) {

		TipoParticipante tipoParticipante = this.tipoParticipanteRepository.findOne(codigo);
		return tipoParticipante != null ? ResponseEntity.ok(tipoParticipante) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.tipoParticipanteRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<TipoParticipante> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody TipoParticipante tipoParticipante) {

		TipoParticipante tipoParticipanteSalvo = this.tipoParticipanteService.atualizar(codigo, tipoParticipante);
		return ResponseEntity.ok(tipoParticipanteSalvo);
	}

}
