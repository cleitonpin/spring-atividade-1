package exercicio.fixacao.one.resources;

import exercicio.fixacao.one.domain.Person;
import exercicio.fixacao.one.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonResource {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/persons")
    public List<Person> getAll() {
       return this.personService.showAll();
    }

    @PostMapping(path = "/person")
    public ResponseEntity<Person> create(@RequestBody Person person) {
       return this.personService.save(person);
    }

    @DeleteMapping(path = "/person/{id}")
    public void delete(@PathVariable Long id) {
       this.personService.delete(id);
    }

    @PutMapping
    public void put(@RequestBody Person person) {
        personService.put(person);
    }
}
