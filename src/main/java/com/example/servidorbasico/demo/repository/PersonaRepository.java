package com.example.servidorbasico.demo.repository;

import com.example.servidorbasico.demo.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

   /* List<Persona> findAllById(Long id);

    Persona delete(Long id);*/
}
