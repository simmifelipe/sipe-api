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
import com.g3softwares.sipe.api.model.TipoIngresso;
import com.g3softwares.sipe.api.repository.TipoIngressoRepository;

@RestController
@RequestMapping("/tipos-ingresso")
public class TipoIngressoResource {

	@Autowired
	private TipoIngressoRepository tipoIngressoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<TipoIngresso> listar() {
		return this.tipoIngressoRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TipoIngresso> criar(@Valid @RequestBody TipoIngresso tipoIngresso,
			HttpServletResponse response) {

		TipoIngresso tipoIngressoSalvo = tipoIngressoRepository.save(tipoIngresso);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoIngressoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoIngressoSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<TipoIngresso> buscarPorCodigo(@PathVariable Long codigo) {
		TipoIngresso tipoIngresso = tipoIngressoRepository.findOne(codigo);
		return tipoIngresso != null ? ResponseEntity.ok(tipoIngresso) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		tipoIngressoRepository.delete(codigo);
	}

}
