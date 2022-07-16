package com.clinic.Clinic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicConfiguration {
	@Autowired
	private ClinicProperties clinicProperties;
	
	@PostConstruct
	public void init() {
		System.out.print("Display owners with pets :" + clinicProperties.isDisplayOwnersWithPets());
	}
}
