package com.zupchallenge.zup.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zupchallenge.zup.domain.model.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long>{
	Optional<Vaccination> findByEmailUser(String emailUser);
}
