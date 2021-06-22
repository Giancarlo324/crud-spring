package co.com.service;

import org.springframework.stereotype.Component;

import co.com.entity.Estado;

@Component
public interface EstadoService {
	public Estado findByCodigo(int codigoEstado);
}
