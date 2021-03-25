package com.zupchallenge.zup.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zupchallenge.zup.domain.model.User;
import com.zupchallenge.zup.domain.model.Vaccination;
import com.zupchallenge.zup.domain.repository.UserRepository;
import com.zupchallenge.zup.domain.repository.VaccinationRepository;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/vaccinations")
public class VaccinationController {
	
	@Autowired
	private VaccinationRepository vaccinationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<Vaccination> index() {
		return vaccinationRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Vaccination> createdVaccination(@Valid @RequestBody Vaccination vaccination) {
		
		// email do usuário que vai receber a vacina
		String emailUser = vaccination.getEmailUser();
		
		// Pesquisa no banco de dados se está cadastrado e se já recebeu a vacina
		Optional<User> userEmail = userRepository.findByEmail(emailUser);
		Optional<Vaccination> userEmailVaccination = vaccinationRepository.findByEmailUser(emailUser);
		
		// Verifica se o usuário está cadastrado
		if(userEmail.isPresent()) {
			// Verifica se o usuário já vacinou
			if(userEmailVaccination.isPresent()) {
				return ResponseEntity.badRequest().build();
			} else {
				return ResponseEntity.ok(vaccinationRepository.save(vaccination));
			}	
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
