package net.rdurvasula.addrbook;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.rdurvasula.addrbook.data.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	List<Contact> findContactByFirstName(String firstName);
}
