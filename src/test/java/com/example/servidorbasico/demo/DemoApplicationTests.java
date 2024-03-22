package com.example.servidorbasico.demo;

import com.example.servidorbasico.demo.controller.PersonaController;
import com.example.servidorbasico.demo.entities.Persona;
import com.example.servidorbasico.demo.service.PersonaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@Mock
	PersonaService personaService;

	@InjectMocks
	PersonaController personaController;

	@Test
	void listAllPersons() {
		List<Persona> listaPersonas = new ArrayList<>();
		Persona persona1 = new Persona(1L, "Juana", "Rodriguez");
		listaPersonas.add(persona1);

		when(personaService.getAll()).thenReturn(listaPersonas);

		List<Persona> response = personaController.getAll();
		//System.out.println(response);

        assertFalse(response.isEmpty());
		assertEquals(persona1, response.get(0));
	}

	@Test
	void getPersonById(){
		List<Persona> listaPersonas = new ArrayList<>();
		Persona persona1 = new Persona(1L, "Juana", "Rodriguez");
		Persona persona2 = new Persona(2L, "Pascual", "Martínez");
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);

		when(personaService.getById(1L)).thenReturn(Optional.ofNullable(listaPersonas.get(0)));

		Optional<Persona> response = personaController.getById(1L);

//		System.out.println(listaPersonas);
//		System.out.println(persona1);
//		System.out.println(response);

		assertTrue(response.isPresent());
		assertEquals(persona1, response.get());

	}

	@Test
	void savePerson(){
		List<Persona> listaPersonas = new ArrayList<>();
		Persona persona1 = new Persona(1L, "Juana", "Rodriguez");
		Persona persona2 = new Persona(2L, "Pascual", "Martínez");
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);

		Persona persona3 = new Persona(3L, "Ada", "Lovelace");

		when(personaService.save(persona3)).thenReturn(persona3);

	//	Optional<Persona> response = personaController.getById(3L);

		Persona response = personaController.save(persona3);

		System.out.println(listaPersonas);
		System.out.println(persona3);
		System.out.println(response);

        assertNotNull(response);
		assertEquals(persona3, response);
	}

	@Test
	void updatePerson(){
		List<Persona> listaPersonas = new ArrayList<>();
		Persona persona1 = new Persona(1L, "Juana", "Rodriguez");
		Persona persona2 = new Persona(2L, "Pascual", "Martínez");
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);

		Persona updatedPersona = new Persona(1L, "Joana", "Rodrigues");

		doNothing().when(personaService).update(updatedPersona, 1L);

		personaController.update( 1L, updatedPersona);

	}

	@Test
	void deletePerson(){
		List<Persona> listaPersonas = new ArrayList<>();
		Persona persona1 = new Persona(1L, "Juana", "Rodriguez");
		Persona persona2 = new Persona(2L, "Pascual", "Martínez");
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);

		personaController.deleteById(1L);

		verify(personaService).delete(1L);
	}

}
