package co.com.repository;

import co.com.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    Persona findByUsername(String username);
    Persona findByCodigo(int codigo);
    Persona findByIdentificacion(int identificacion);
}
