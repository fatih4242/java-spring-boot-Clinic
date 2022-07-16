package com.clinic.Clinic;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="petclinic")
public class ClinicProperties {
	
	private boolean displayOwnersWithPets =false;
	
	public boolean isDisplayOwnersWithPets() {
		return displayOwnersWithPets;
	}
	
	public void setDisplayOwnersWithPets(boolean displayOwnersWithPets) {
		this.displayOwnersWithPets = displayOwnersWithPets;
	}
}
