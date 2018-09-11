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
import com.g3softwares.sipe.api.model.ItemCheckList;
import com.g3softwares.sipe.api.repository.ItemCheckListRepository;
import com.g3softwares.sipe.api.service.ItemCheckListService;

@RestController
@RequestMapping("/item-check-list")
public class ItemCheckListResource {

	@Autowired
	private ItemCheckListRepository itemCheckListRepository;

	@Autowired
	private ItemCheckListService itemCheckListService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<ItemCheckList> listar() {
		return this.itemCheckListRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ItemCheckList> criar(@Valid @RequestBody ItemCheckList itemCheckList,
			HttpServletResponse response) {

		ItemCheckList itemCheckListSalvo = itemCheckListRepository.save(itemCheckList);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, itemCheckListSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(itemCheckListSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ItemCheckList> buscarPorCodigo(@PathVariable Long codigo) {
		ItemCheckList itemCheckList = itemCheckListRepository.findOne(codigo);
		return itemCheckList != null ? ResponseEntity.ok(itemCheckList) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		itemCheckListRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ItemCheckList> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody ItemCheckList itemCheckList) {
		ItemCheckList itemCheckListSalvo = itemCheckListService.atualizar(codigo, itemCheckList);
		return ResponseEntity.ok(itemCheckListSalvo);
	}

}
