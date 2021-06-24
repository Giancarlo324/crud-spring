package co.com.controller;

import co.com.dto.UserLoginDto;
import co.com.dto.UserRegisterDto;
import co.com.entity.Persona;
import co.com.service.PersonaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import co.com.service.JwtUserDetailsService;
import co.com.config.JwtTokenUtil;
import co.com.entity.JwtRequest;
import co.com.entity.JwtResponse;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JwtAuthenticationController {

	@Autowired
	private PersonaService personaService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		UserLoginDto userLoginDto = new UserLoginDto();
		userLoginDto.setUsername(authenticationRequest.getUsername());
		userLoginDto.setPassword(authenticationRequest.getPassword());

		authenticate(userLoginDto);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping(value = "/register")
	public ResponseEntity<Response> registerUser(@RequestBody UserRegisterDto user) {

		Persona personaByCodigo = personaService.getPersonaByCodigo(user.getCodigo());
		Persona personaByUsername = personaService.getPersonaByUsername(user.getUsername());
		Persona personaByIdentificacion =
				personaService.getPersonaByIdentificacion(user.getIdentificacion());

		Response response = new Response();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Fallo al registrar usuario");

		if(personaByCodigo != null || personaByUsername != null || personaByIdentificacion != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Usuario registrado correctamente");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void authenticate(UserLoginDto userLoginDto) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							userLoginDto.getUsername(), userLoginDto.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
