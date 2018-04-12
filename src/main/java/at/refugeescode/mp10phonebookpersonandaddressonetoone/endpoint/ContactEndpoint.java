package at.refugeescode.mp10phonebookpersonandaddressonetoone.endpoint;

import at.refugeescode.mp10phonebookpersonandaddressonetoone.persistence.model.Contact;
import at.refugeescode.mp10phonebookpersonandaddressonetoone.persistence.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactEndpoint {

    private ContactRepository contactRepository;

    public ContactEndpoint(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping
    List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    Contact findOneById(@PathVariable Long id) {
        return contactRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    Contact addNew(@RequestBody Contact person) {
        return contactRepository.save(person);
    }

    @DeleteMapping("/{id}")
    void removeOneById(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }

}
