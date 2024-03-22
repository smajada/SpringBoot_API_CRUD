package com.example.servidorbasico.demo.controller;

import com.example.servidorbasico.demo.entities.Persona;
import com.example.servidorbasico.demo.service.PersonaService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PersonaController {

    private final PersonaService personaService;


    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    //API
    @GetMapping("/persona")
    public List<Persona> getAll(){
      return  personaService.getAll();
    }

    @GetMapping("/persona/{id}")
    public Optional<Persona> getById(@PathVariable Long id){
        return personaService.getById(id);
    }

    @PostMapping("/persona")
    public Persona save(@RequestBody Persona persona){
        return personaService.save(persona);
    }

    @DeleteMapping("/persona/{id}")
    public void deleteById(@PathVariable Long id){
        personaService.delete(id);
    }

    @PutMapping("persona/{id}")
    public void update(@PathVariable Long id, @RequestBody Persona persona){
        personaService.update(persona, id);
    }
}
