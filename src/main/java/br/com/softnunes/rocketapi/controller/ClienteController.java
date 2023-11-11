package br.com.softnunes.rocketapi.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.softnunes.rocketapi.dto.ClienteDto;
import br.com.softnunes.rocketapi.model.Municipio;
import br.com.softnunes.rocketapi.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.softnunes.rocketapi.model.Cliente;
import br.com.softnunes.rocketapi.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ClienteService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody @Valid ClienteDto clienteDto) {
		return service.salvar(clienteDto);

	}
	
	@GetMapping
	public List<Cliente> obterTodos(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENTE NÃO ENCONTRADO"));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		repository.findById(id).map(cliente -> {
			repository.delete(cliente);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENTE NÃO ENCONTRADO"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		repository.findById(id)
		.map(cliente -> {
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setCpf(clienteAtualizado.getCpf());
			return repository.save(clienteAtualizado);
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENTE NÃO ENCONTRADO"));
	}
}
