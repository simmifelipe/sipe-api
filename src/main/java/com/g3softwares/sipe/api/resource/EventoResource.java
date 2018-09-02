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
import com.g3softwares.sipe.api.model.Evento;
import com.g3softwares.sipe.api.repository.EventoRepository;
import com.g3softwares.sipe.api.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private EventoService eventoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Evento> listar() {
		return this.eventoRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Evento> criar(@Valid @RequestBody Evento evento, HttpServletResponse response) {

		Evento eventoSalvo = eventoRepository.save(evento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, eventoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Evento> buscarPorCodigo(@PathVariable Long codigo) {
		Evento evento = eventoRepository.findOne(codigo);
		return evento != null ? ResponseEntity.ok(evento) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		eventoRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Evento> atualizar(@PathVariable Long codigo, @Valid @RequestBody Evento evento) {
		Evento eventoSalvo = eventoService.atualizar(codigo, evento);
		return ResponseEntity.ok(eventoSalvo);
	}

}
