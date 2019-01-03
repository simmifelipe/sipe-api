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
import com.g3softwares.sipe.api.model.EmpresaUsuario;
import com.g3softwares.sipe.api.model.Liberacao;
import com.g3softwares.sipe.api.repository.LiberacaoRepository;
import com.g3softwares.sipe.api.service.LiberacaoService;

@RestController
@RequestMapping("/liberacoes")
public class LiberacaoResource {

	@Autowired
	private LiberacaoRepository liberacaoRepository;

	@Autowired
	private LiberacaoService liberacaoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Liberacao> listar() {
		return this.liberacaoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Liberacao> criar(@Valid @RequestBody Liberacao liberacao, HttpServletResponse response) {

		Liberacao liberacaoSalva = this.liberacaoRepository.save(liberacao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, liberacaoSalva.getLiberacaoPK()));
		return ResponseEntity.status(HttpStatus.CREATED).body(liberacaoSalva);
	}

	@GetMapping("/usuario/{codigo}")
	public List<Liberacao> buscarPorUsuario(@PathVariable Long codigo) {
		return this.liberacaoService.buscarPorUsuario(codigo);
	}
	
	@GetMapping("/usuario/{usuario}/disponiveis")
	public List<EmpresaUsuario> liberacoesDisponiveis(@PathVariable Long usuario) {
		return this.liberacaoService.carregarLiberacoesDisponiveis(usuario);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.liberacaoRepository.delete(codigo);
	}

}
