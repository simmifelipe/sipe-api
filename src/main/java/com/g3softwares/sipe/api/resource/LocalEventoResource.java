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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.g3softwares.sipe.api.event.RecursoCriadoEvent;
import com.g3softwares.sipe.api.model.LocalEvento;
import com.g3softwares.sipe.api.repository.LocalEventoRepository;

@RestController
@RequestMapping("/locais-evento")
public class LocalEventoResource {

	@Autowired
	private LocalEventoRepository localEventoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<LocalEvento> listar() {
		return this.localEventoRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<LocalEvento> criar(@Valid @RequestBody LocalEvento localEvento,
			HttpServletResponse response) {

		LocalEvento localEventoSalvo = localEventoRepository.save(localEvento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, localEventoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(localEventoSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<LocalEvento> buscarPorCodigo(@PathVariable Long codigo) {
		LocalEvento localEvento = localEventoRepository.findOne(codigo);
		return localEvento != null ? ResponseEntity.ok(localEvento) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		localEventoRepository.delete(codigo);
	}

}
