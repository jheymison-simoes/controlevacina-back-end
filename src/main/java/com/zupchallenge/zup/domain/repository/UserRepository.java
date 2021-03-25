package com.zupchallenge.zup.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zupchallenge.zup.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByName(String name); 
	List<User> findByNameContaining(String name);
	Optional<User> findByEmail(String email);
	Optional<User> findByCpf(String cpf);
}
