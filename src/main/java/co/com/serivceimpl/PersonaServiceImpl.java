package co.com.serivceimpl;

import co.com.entity.Persona;
import co.com.repository.PersonaRepository;
import co.com.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    PersonaRepository personaRepository;


    @Override
    public List<Persona> getPersonas() {
        List<Persona> personaList = new ArrayList<>();
        personaRepository.findAll().forEach(personaList::add);
        return personaList;
    }

    @Override
    public Persona getPersonaByCodigo(int codigo) {
        return personaRepository.findById(codigo).get();
    }

    @Override
    public Persona insert(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void updatePersona(int codigo, Persona persona) {
        Persona personaFromDb = personaRepository.findById(codigo).get();
        personaFromDb.setNombre(persona.getNombre());
        personaFromDb.setApellido(persona.getApellido());
        personaFromDb.setCodigoEstado(persona.getCodigoEstado());
        personaFromDb.setIdentificacion(persona.getIdentificacion());
        personaRepository.save(personaFromDb);
    }

    @Override
    public void deletePersona(int codigo) {
        personaRepository.deleteById(codigo);
    }
}
