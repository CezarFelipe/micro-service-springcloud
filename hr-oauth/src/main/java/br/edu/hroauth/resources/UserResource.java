package br.edu.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.hroauth.entities.User;
import br.edu.hroauth.services.UserService;

@RestController
@RequestMapping(value ="/users/")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) throws IllegalAccessException{
		
		
		User user = service.findByEmail(email);
		return ResponseEntity.ok(user);
		
		
	}
}
