package at.refugeescode.mp10phonebookpersonandaddressonetoone.endpoint;

import at.refugeescode.mp10phonebookpersonandaddressonetoone.persistence.model.Person;
import at.refugeescode.mp10phonebookpersonandaddressonetoone.persistence.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class PersonEndpoint {

    private PersonRepository personRepository;

    public PersonEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    Person findOneById(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    Person addNew(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    void removeOneById(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

}
