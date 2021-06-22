package co.com.serivceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.entity.Estado;
import co.com.service.EstadoService;
import co.com.repository.EstadoRepository;

@Service("estadoServiceImpl")
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public Estado findByCodigo(int codigoEstado) {
		Estado estado = estadoRepository.findByCodigo(codigoEstado);
		return estado;
	}
}
