package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class contactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;
	
	

	@Override
	public String saveContact(Contact contact) {
		
		Contact save = repo.save(contact);
		
		if(save.getContactId()!=null) {
			
			return "Contact Saved Successfully";
			
		}else {
				
				return "Contact failed to save";
			}
		}
		
		
	

	@Override
	public List<Contact> getAllContact() {
		
		List<Contact> contacts=repo.findAll();
		
		return contacts;
		
		
		
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
		Optional<Contact> findById=repo.findById(contactId);
		
		if (findById.isPresent()){
			
			return findById.get();
			
		}else {
			return null;
		}
		
	}

	@Override
	public String updateContact(Contact contact) {
		
		if(repo.existsById(contact.getContactId())) {
			
			repo.save(contact);
			return "update success";
			
		}else {
			return "update failed as record not found";
		}
		
	}

	@Override
	public String deleteContactById(Integer contactId) {
		
		if (repo.existsById(contactId)) {
			
			repo.deleteById(contactId);
			return "record deleted successfully";
			
		}else {
			
			return "deletion failed as record not found";
		}
		
	}
	

}
