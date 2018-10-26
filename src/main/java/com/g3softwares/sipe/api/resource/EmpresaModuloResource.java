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
import com.g3softwares.sipe.api.model.EmpresaModulo;
import com.g3softwares.sipe.api.repository.EmpresaModuloRepository;

@RestController
@RequestMapping("/empresas-modulos")
public class EmpresaModuloResource {

	@Autowired
	private EmpresaModuloRepository empresaModuloRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<EmpresaModulo> listar() {
		return this.empresaModuloRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<EmpresaModulo> criar(@Valid @RequestBody EmpresaModulo empresaModulo,
			HttpServletResponse response) {

		EmpresaModulo empresaModuloSalva = this.empresaModuloRepository.save(empresaModulo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, empresaModuloSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaModuloSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<EmpresaModulo> buscarPorCodigo(@PathVariable Long codigo) {

		EmpresaModulo empresaModulo = this.empresaModuloRepository.findOne(codigo);
		return empresaModulo != null ? ResponseEntity.ok(empresaModulo) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.empresaModuloRepository.delete(codigo);
	}

}
