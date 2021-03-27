package com.zupchallenge.zup.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zupchallenge.zup.domain.model.User;
import com.zupchallenge.zup.domain.repository.UserRepository;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
		
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> index() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> searchUser(@PathVariable Long userId) {
		Optional<User> user =  userRepository.findById(userId);
		
		//Vertifica há algum usuário com o ID informado
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		String email = user.getEmail();
		String cpf = user.getCpf();
		
		// Procura se ja existe o usuário no banco de dados
		Optional<User> userCpf = userRepository.findByCpf(cpf);
		Optional<User> userEmail = userRepository.findByEmail(email);
		
		// Verifica se ja há cadastro com email ou cpf no banco de dados
		if(userCpf.isPresent() || userEmail.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {
			//return ResponseEntity.ok(userRepository.save(user));
			
			return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
		}
		
	}
	
}
