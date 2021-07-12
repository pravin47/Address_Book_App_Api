package com.bridgelabz.addressbookapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapi.dto.ContactDTO;
import com.bridgelabz.addressbookapi.model.ContactModel;
import com.bridgelabz.addressbookapi.service.IContactService;
import com.bridgelabz.addressbookapi.util.Response;


@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	IContactService contactservice;
	
	@PostMapping("/addnewcontact")
	ResponseEntity<Response> createcontact(@Valid @RequestBody ContactDTO contactdto)
	{
		Response response=contactservice.addcontact(contactdto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping("/updatecontact/{token}")
	ResponseEntity<Response> updatecontact(@PathVariable String token, @RequestBody ContactDTO contactdto)
	{
		Response response=contactservice.updatecontact(token,contactdto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getallContact/{token}")
	ResponseEntity<List<?>> getallContact(@PathVariable String token)
	{
		List<ContactModel> response = contactservice.getallContact(token);
		return new ResponseEntity<List<?>>(response,HttpStatus.OK);
	}
	@GetMapping("/address/{token}")
	ResponseEntity<List<?>> getAddress(@PathVariable String token,@RequestParam String address)
	{
		List<ContactModel> response = contactservice.getAddress(token, address);
		return new ResponseEntity<List<?>>(response,HttpStatus.OK);
	}
	@GetMapping("/getContact")
	ResponseEntity<List<?>> getContact()
	{
		List<ContactModel> response = contactservice.getContact();
		return new ResponseEntity<List<?>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getcity/{token}")
	ResponseEntity<List<?>> getCity(@PathVariable String token,@RequestParam String City)
	{
		List<ContactModel> response=contactservice.getCity(token,City);
		return new ResponseEntity<List<?>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/pincode/{token}")
	ResponseEntity<List<?>> getPinCode(@PathVariable String token, @RequestParam String pinCode)
	{
		List<ContactModel> response = contactservice.getPinCode(token, pinCode);
		return new ResponseEntity<List<?>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletcontact")
	ResponseEntity<Response> deletcontact(@RequestParam String token)
	{
		Response response=contactservice.deletcontact(token);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}