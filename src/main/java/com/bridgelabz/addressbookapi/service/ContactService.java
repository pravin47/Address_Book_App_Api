package com.bridgelabz.addressbookapi.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapi.dto.ContactDTO;
import com.bridgelabz.addressbookapi.exception.ContactRegisterException;
import com.bridgelabz.addressbookapi.model.ContactModel;
import com.bridgelabz.addressbookapi.repository.ContactRepository;
import com.bridgelabz.addressbookapi.util.Response;
import com.bridgelabz.addressbookapi.util.TokenUtil;

@Service
public class ContactService implements IContactService
{

	@Autowired
	ContactRepository contactrepository;
	
	@Autowired
	ModelMapper modelmapper;
	@Autowired
	TokenUtil tokenutil;

	@Override
	public Response addcontact(ContactDTO contactdto) 
	{
		Optional<ContactModel> isPresent=contactrepository.findByEmailid(contactdto.getEmailid());
		if(isPresent.isPresent()) 
		{
			throw new ContactRegisterException(400, "Contact Already Added");
		}else 
		{
			ContactModel contact=modelmapper.map(contactdto, ContactModel.class);
			contactrepository.save(contact);
			String token=tokenutil.createToken(contact.getId());
			return new Response(200, "Contact Succefully Added", token);
		}
		
	}

	@Override
	public Response updatecontact(String token, ContactDTO contactdto) 
	{
		Long id = tokenutil.decodeToken(token);
		Optional<ContactModel>isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) 
		{
			System.out.println(isContactPresent.get());
			isContactPresent.get().setFirstname(contactdto.getFirstname());
			isContactPresent.get().setAddress(contactdto.getAddress());
		//	isContactPresent.get().setLastname(contactdto.getLastname());
			isContactPresent.get().setEmailid(contactdto.getEmailid());
			isContactPresent.get().setUpdatedDate(LocalDateTime.now());
			isContactPresent.get().setMobilenumber(contactdto.getMobilenumber());
			isContactPresent.get().setCity(contactdto.getCity());
			isContactPresent.get().setPinCode(contactdto.getPinCode());
			contactrepository.save(isContactPresent.get());
			return new Response(200, "Contact Succefully Updated", null);
		}
		else 
		{
			throw new ContactRegisterException(400, "Contact is not saved!");
	    }

	}

	@Override
	public List<ContactModel> getallContact(String token) 
	{
		Long id = tokenutil.decodeToken(token);
		Optional<ContactModel>isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) 
		{
			List<ContactModel> getallContact = contactrepository.findAll();
			return getallContact;
		}
		else 
		{
			throw new ContactRegisterException(400, "Token is not valid!");
		}
	}

	@Override
	public Response deletcontact(String token) 
	{
		long id = tokenutil.decodeToken(token);
		Optional<ContactModel> isThere = contactrepository.findById(id);
		if (isThere.isPresent())
		{
			contactrepository.delete(isThere.get());
			return new Response(400,"Deleted Successfully" , HttpStatus.ACCEPTED);
		}else 
		{
			throw new ContactRegisterException(500 , "Contact could not be found to be deleted");
		}
	}

	@Override
	public List<ContactModel> getCity(String token, String city) 
	{
		Long id=tokenutil.decodeToken(token);
		Optional<ContactModel> isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) {
			List<ContactModel> getcontactsbycity=contactrepository.findByCityStartsWith(city);
			
			return getcontactsbycity;
			
			
		}else {
			throw new ContactRegisterException(400, "Contact is not preset!!");
		}
	
	}

	@Override
	public List<ContactModel> getPinCode(String token, String pinCode) 
	{
		Long id = tokenutil.decodeToken(token);
		Optional<ContactModel>isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) 
		{
			List<ContactModel> getContactByPinCode=contactrepository.findByPinCodeStartsWith(pinCode);
			return getContactByPinCode;
		}
		else 
		{
			throw new ContactRegisterException(400, "Contact is not preset!!");
		}
		
	}

	@Override
	public List<ContactModel> getContact() 
	{
			List<ContactModel> getContact = contactrepository.findAll();
			return getContact;

	}

	@Override
	public List<ContactModel> getAddress(String token, String address) 
	{
		Long id=tokenutil.decodeToken(token);
		Optional<ContactModel> isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) {
			List<ContactModel> getAddress=contactrepository.findContactByAddress(address);
			return getAddress;
		}else {
			throw new ContactRegisterException(400, "Adress is not preset!!");
		}
	
	}
}