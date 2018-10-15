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
import com.g3softwares.sipe.api.model.Empresa;
import com.g3softwares.sipe.api.model.Utilizador;
import com.g3softwares.sipe.api.repository.EmpresaRepository;
import com.g3softwares.sipe.api.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Empresa> listar() {
		return this.empresaRepository.findAll();
	}

	@GetMapping("/utilizador/{codigo}")
	public List<Empresa> buscarPorUtilizador(Utilizador utilizador) {
		return this.empresaRepository.findByUtilizador(utilizador);
	}

	@PostMapping()
	public ResponseEntity<Empresa> criar(@Valid @RequestBody Empresa empresa, HttpServletResponse response) {

		Empresa empresaSalva = this.empresaRepository.save(empresa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, empresaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Empresa> buscarPorCodigo(@PathVariable Long codigo) {

		Empresa empresa = this.empresaRepository.findOne(codigo);
		return empresa != null ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.empresaRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Empresa empresa) {

		Empresa empresaSalva = this.empresaService.atualizar(codigo, empresa);
		return ResponseEntity.ok(empresaSalva);
	}

	@PutMapping("/{codigo}/ativo")
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {

		this.empresaService.atualizarPropriedadeAtivo(codigo, ativo);
	}

}
