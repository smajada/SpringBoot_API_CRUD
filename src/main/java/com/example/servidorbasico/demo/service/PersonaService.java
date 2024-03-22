package com.example.servidorbasico.demo.service;

import com.example.servidorbasico.demo.entities.Persona;
import com.example.servidorbasico.demo.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAll(){

        return personaRepository.findAll();
    }

    public Optional<Persona> getById(Long id){
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona){
        return personaRepository.save(persona);
    }

    public void delete(Long id) {
       personaRepository.deleteById(id);
    }

    public void update(Persona persona, Long id){
       personaRepository.findById(id)
               .ifPresent(persona1 -> {
                   persona1.setFirstName(persona.getFirstName());
                   persona1.setLastName(persona.getLastName());

                   personaRepository.save(persona1);
               });
    }
}
