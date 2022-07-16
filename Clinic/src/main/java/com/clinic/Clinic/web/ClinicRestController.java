package com.clinic.Clinic.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import com.clinic.Clinic.exception.OwnerNotFoundException;
import com.clinic.Clinic.model.Owner;
import com.clinic.Clinic.service.ClinicService;

@RestController
@RequestMapping("/rest")
public class ClinicRestController {
	
	@Autowired
	private ClinicService clinicService;

	@RequestMapping(method = RequestMethod.POST, value="/owner")
	public ResponseEntity<URI> createOwner(@RequestBody Owner owner){
		
		try {
			Long id = owner.getId();
			clinicService.createOwner(owner);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/owners")
	public ResponseEntity<List<Owner>> getOwners(){
		
		List<Owner> owners = clinicService.findOwners();
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/owner")
	public ResponseEntity<List<Owner>> getOwners(@RequestParam("ln") String lastName){
		List<Owner> owners = clinicService.findOwners(lastName);
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/owner/{id}")
	public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id){
		try {
			Owner owner = clinicService.findOwner(id);
			return ResponseEntity.ok(owner);
		}catch(OwnerNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
