package co.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	public Estado findByCodigo(int codigoEstado);
}
