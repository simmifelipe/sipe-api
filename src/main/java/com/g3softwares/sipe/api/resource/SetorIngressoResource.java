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
import com.g3softwares.sipe.api.model.SetorIngresso;
import com.g3softwares.sipe.api.model.Utilizador;
import com.g3softwares.sipe.api.repository.SetorIngressoRepository;

@RestController
@RequestMapping("/setores-ingresso")
public class SetorIngressoResource {

	@Autowired
	private SetorIngressoRepository setorIngressoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<SetorIngresso> listar() {
		return this.setorIngressoRepository.findAll();
	}
	
	@GetMapping("/utilizador/{codigo}")
	public List<SetorIngresso> buscarPorUtilizador(Utilizador utilizador) {
		return this.setorIngressoRepository.findByUtilizador(utilizador);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SetorIngresso> criar(@Valid @RequestBody SetorIngresso setorIngresso,
			HttpServletResponse response) {

		SetorIngresso setorIngressoSalvo = setorIngressoRepository.save(setorIngresso);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, setorIngressoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(setorIngressoSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<SetorIngresso> buscarPorCodigo(@PathVariable Long codigo) {
		SetorIngresso setorIngresso = setorIngressoRepository.findOne(codigo);
		return setorIngresso != null ? ResponseEntity.ok(setorIngresso) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		setorIngressoRepository.delete(codigo);
	}

}
