package com.bridgelabz.addressbookapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.addressbookapi.model.ContactModel;

public interface ContactRepository extends JpaRepository<ContactModel, Long> 
{
	 public Optional<ContactModel> findByEmailid(String emailid);

     public Optional<ContactModel> findById(Long id);
	
	 public List<ContactModel> findByCityStartsWith(String city);

	 public List<ContactModel> findByPinCodeStartsWith(String pinCode);

	 @Query(value = "select * from contact, user_address where id = user_id and address =:add", nativeQuery = true)
		List<ContactModel> findContactByAddress(String add);

}