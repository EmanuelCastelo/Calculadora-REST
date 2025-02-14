package br.com.ec.calculadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ec.calculadora.model.Person;
import br.com.ec.calculadora.services.PersonServices;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service = new PersonServices();

	@GetMapping()
	public List<Person> findById() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public Person findById(@PathParam(value = "id") String id) {
		return service.findById(id);
	}

}
