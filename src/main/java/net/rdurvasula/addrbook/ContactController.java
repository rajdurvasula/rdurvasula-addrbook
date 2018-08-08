package net.rdurvasula.addrbook;


import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	static Logger logger = LogManager.getLogger(ContactController.class);

	@Autowired
	ContactRepository contactRepo;
	
	@PostMapping("/myaddrbook/save")
	public Contact save(@Valid @RequestBody Contact contact) {
		logger.info("save - begin");
		contactRepo.save(contact);
		logger.info("Contact created with Id: {}.", String.valueOf(contact.getId()));
		logger.info("save - end");
		return contact;
	}
	
	@GetMapping("/myaddrbook/{contactId}")
	public Contact findById(@PathVariable Long contactId) {
		logger.info("findById - begin");
		Contact contact = contactRepo.findOne(contactId);
		if (null != contact) {
			logger.info("Contact found with Firstname = {} , Lastname = {}.",contact.getFirstName(), contact.getLastName());
		}
		logger.info("findById - end");
		return contact;
	}
	
	@PutMapping("/myaddrbook/{contactId}")
	public Contact update(@PathVariable Long contactId, @Valid @RequestBody Contact contact) {
		logger.info("update - begin");
		if (!contactRepo.exists(contactId)) {
			logger.warn("Contact with Id: {} not found !", String.valueOf(contactId));
			throw new ResourceUnavailable("Contact with Id: "+String.valueOf(contactId)+" not found !");
		}
		Contact record = contactRepo.findOne(contactId);
		record.setCompany(contact.getCompany());
		record.setFirstName(contact.getFirstName());
		record.setLastName(contact.getLastName());
		record.setTitle(contact.getTitle());
		record.setGroupName(contact.getGroupName());
		logger.info("Contact with Id: {} updated.", String.valueOf(record.getId()));
		logger.info("update - end");
		return contactRepo.save(record);
	}
}
