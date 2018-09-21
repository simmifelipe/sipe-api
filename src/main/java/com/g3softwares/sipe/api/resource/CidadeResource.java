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
import com.g3softwares.sipe.api.model.Cidade;
import com.g3softwares.sipe.api.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Cidade> listar() {
		return this.cidadeRepository.findAll();
	}

	@GetMapping("/pesquisa/{nome}")
	public List<Cidade> buscarPorDescricao(@PathVariable String nome) {
		return this.cidadeRepository.findByNomeIgnoreCaseContaining(nome);
	}

	@PostMapping
	public ResponseEntity<Cidade> criar(@Valid @RequestBody Cidade cidade, HttpServletResponse response) {

		Cidade cidadeSalva = this.cidadeRepository.save(cidade);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cidadeSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Cidade> buscarPorCodigo(@PathVariable Long codigo) {

		Cidade cidade = this.cidadeRepository.findOne(codigo);
		return cidade != null ? ResponseEntity.ok(cidade) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.cidadeRepository.delete(codigo);
	}

}
