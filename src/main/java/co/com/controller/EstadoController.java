package co.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.entity.Estado;
import co.com.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping(value = "/getEstado", method = RequestMethod.GET)
	@ResponseBody
	public Estado getEstado(int codigoEstado) {
		return estadoService.findByCodigo(codigoEstado);
	}	

}
