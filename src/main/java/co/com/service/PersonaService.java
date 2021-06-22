package co.com.service;

import co.com.entity.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> getPersonas();

    Persona getPersonaByCodigo(int codigo);

    Persona insert(Persona persona);

    void updatePersona(int codigo, Persona persona);

    void deletePersona(int codigo);
}
