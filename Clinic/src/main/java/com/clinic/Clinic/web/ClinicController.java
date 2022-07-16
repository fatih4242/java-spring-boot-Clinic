package com.clinic.Clinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.clinic.Clinic.service.ClinicService;

@Controller
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping("/owners")
	public ModelAndView getOwners() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("owners", clinicService.findOwners());
		System.out.println("your output ---------_>"+ clinicService.findOwners());
		mav.setViewName("owners");
		return mav;
	}
	
	@RequestMapping("/pcs")
	@ResponseBody
	public String welcome() {
		return "Welcome to Petclinic World";
	}
	

}
