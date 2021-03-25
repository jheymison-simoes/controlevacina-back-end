package com.zupchallenge.zup.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vaccinations")
public class Vaccination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "name_vaccine")
	private String nameVaccine;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "date_vaccination")
	private String dateVaccination;
	
	@NotBlank
	@Email
	@Size(max = 255)
	@Column(name = "email_user")
	private String emailUser;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNameVaccine() {
		return nameVaccine;
	}
	
	public void setNameVaccine(String nameVaccine) {
		this.nameVaccine = nameVaccine;
	}
	
	public String getDateVaccination() {
		return dateVaccination;
	}
	
	public void setDateVaccination(String dateVaccination) {
		this.dateVaccination = dateVaccination;
	}
	
	public String getEmailUser() {
		return emailUser;
	}
	
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaccination other = (Vaccination) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
