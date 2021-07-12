package com.bridgelabz.addressbookapi.service;
import java.util.List;
import com.bridgelabz.addressbookapi.dto.ContactDTO;
import com.bridgelabz.addressbookapi.model.ContactModel;
import com.bridgelabz.addressbookapi.util.Response;

public interface IContactService {

	Response addcontact(ContactDTO contactdto);

	Response updatecontact(String token, ContactDTO contactdto);

	List<ContactModel> getallContact(String token);

	Response deletcontact(String token);

	List<ContactModel> getContact();

	List<ContactModel> getCity(String token, String city);

	List<ContactModel> getPinCode(String token, String pinCode);

	List<ContactModel> getAddress(String token, String address);

}