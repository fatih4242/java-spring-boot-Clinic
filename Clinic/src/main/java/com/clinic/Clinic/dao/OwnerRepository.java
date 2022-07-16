package com.clinic.Clinic.dao;

import java.util.List;

import com.clinic.Clinic.model.Owner;

public interface OwnerRepository {

	
	List<Owner> findAll();
	Owner findById(long id);
	List<Owner> findByLastName(String lastName);
	void create(Owner owner);
	Owner update(Owner owner);
	void delete(Long id);
	
}
