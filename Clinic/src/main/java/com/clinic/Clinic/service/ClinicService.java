package com.clinic.Clinic.service;

import java.util.List;

import com.clinic.Clinic.exception.OwnerNotFoundException;
import com.clinic.Clinic.model.Owner;

public interface ClinicService {
	List<Owner> findOwners();
	List<Owner> findOwners(String lastName);
	Owner findOwner(Long id) throws OwnerNotFoundException;
	void createOwner(Owner owner);
	void update(Owner owner);
	void delete(Long id);
}
