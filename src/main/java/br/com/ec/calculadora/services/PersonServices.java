package br.com.ec.calculadora.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.ec.calculadora.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {

		logger.info("Finding all people");

		List<Person> people = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			people.add(person);
		}

		return people;
	}

	public Person findById(String id) {

		logger.info("Finding one person");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Emanuel");
		person.setLastName("Castelo");
		person.setAddress("Jacareí");
		person.setGender("Male");

		return person;

	}

	private Person mockPerson(int i) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("First" + i);
		person.setLastName("Last" + i);
		person.setAddress("Address" + i);
		person.setGender("Gender" + i);

		return person;
	}

}
