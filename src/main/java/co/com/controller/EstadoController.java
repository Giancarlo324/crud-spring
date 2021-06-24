package co.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.com.entity.Estado;
import co.com.service.EstadoService;

@RequestMapping("/estado")
@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;

	@GetMapping(value = "/getEstado")
	@ResponseBody
	public Estado getEstado(int codigoEstado) {
		return estadoService.findByCodigo(codigoEstado);
	}

	@RequestMapping("/hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}

}
