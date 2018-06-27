package net.rdurvasula.addrbook;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.rdurvasula.addrbook.data.Contact;

@RestController
public class ContactController {

	@Autowired
	ContactRepository contactRepo;
	
	@PostMapping("/myaddrbook/save")
	public Contact save(@Valid @RequestBody Contact contact) {
		contactRepo.save(contact);
		return contact;
	}
	
	@GetMapping("/myaddrbook/{contactId}")
	public Contact findById(@PathVariable Long contactId) {
		return contactRepo.findOne(contactId);
	}
	
	@PutMapping("/myaddrbook/{contactId}")
	public Contact update(@PathVariable Long contactId, @Valid @RequestBody Contact contact) {
		if (!contactRepo.exists(contactId)) {
			throw new ResourceUnavailable("Contact with Id: "+String.valueOf(contactId)+" not found !");
		}
		Contact record = contactRepo.findOne(contactId);
		record.setCompany(contact.getCompany());
		record.setFirstName(contact.getFirstName());
		record.setLastName(contact.getLastName());
		record.setTitle(contact.getTitle());
		record.setGroupName(contact.getGroupName());
		return contactRepo.save(record);
	}
}
