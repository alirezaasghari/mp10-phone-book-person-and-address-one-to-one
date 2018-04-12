package at.refugeescode.mp10phonebookpersonandaddressonetoone.persistence.repository;

import at.refugeescode.mp10phonebookpersonandaddressonetoone.persistence.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
