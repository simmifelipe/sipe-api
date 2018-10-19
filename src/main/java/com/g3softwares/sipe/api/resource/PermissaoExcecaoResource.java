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

import com.g3softwares.sipe.api.model.PermissaoExcecao;
import com.g3softwares.sipe.api.repository.PermissaoExcecaoRepository;

@RestController
@RequestMapping("/permissoes-excecoes")
public class PermissaoExcecaoResource {

	@Autowired
	private PermissaoExcecaoRepository permissaoExcecaoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<PermissaoExcecao> listar() {
		return this.permissaoExcecaoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<PermissaoExcecao> criar(@Valid @RequestBody PermissaoExcecao permissaoExcecao,
			HttpServletResponse response) {

		PermissaoExcecao permissaoExcecaoSalva = this.permissaoExcecaoRepository.save(permissaoExcecao);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, permissaoExcecaoSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(permissaoExcecaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<PermissaoExcecao> buscarPorCodigo(@PathVariable Long codigo) {

		PermissaoExcecao permissaoExcecao = this.permissaoExcecaoRepository.findOne(codigo);
		return permissaoExcecao != null ? ResponseEntity.ok(permissaoExcecao) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.permissaoExcecaoRepository.delete(codigo);
	}

}
