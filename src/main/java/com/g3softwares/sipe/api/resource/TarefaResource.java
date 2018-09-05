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
import com.g3softwares.sipe.api.model.Tarefa;
import com.g3softwares.sipe.api.repository.TarefaRepository;
import com.g3softwares.sipe.api.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Tarefa> listar() {
		return this.tarefaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Tarefa> criar(@Valid @RequestBody Tarefa tarefa, HttpServletResponse response) {

		Tarefa tarefaSalva = this.tarefaRepository.save(tarefa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tarefaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Tarefa> buscarPorCodigo(@PathVariable Long codigo) {

		Tarefa tarefa = this.tarefaRepository.findOne(codigo);
		return tarefa != null ? ResponseEntity.ok(tarefa) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.tarefaRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Tarefa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Tarefa tarefa) {

		Tarefa tarefaSalva = this.tarefaService.atualizar(codigo, tarefa);
		return ResponseEntity.ok(tarefaSalva);
	}

}
