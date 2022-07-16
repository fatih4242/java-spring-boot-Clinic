package com.clinic.Clinic.dao;

import java.util.List;

import com.clinic.Clinic.model.Pet;

public interface ClinicRepository {
	Pet findById(long id);
	List<Pet> findByOwner(long ownerId);
	void create(Pet pet);
	Pet update(Pet pet);
	void delete(Long id);
	void deleteByOwner(long ownerId);
}
