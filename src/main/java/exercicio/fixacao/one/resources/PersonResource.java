package exercicio.fixacao.one.resources;

import exercicio.fixacao.one.domain.Person;
import exercicio.fixacao.one.repository.PersonRepository;
import exercicio.fixacao.one.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PersonResource {

    @Autowired
    private PersonService _personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> buscarPorId(@PathVariable("id") Long id) throws Exception {
        Person person = this._personService.findById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping(path = "/persons")
    public List<Person> getAll() {
       return this._personService.showAll();
    }

    @PostMapping(path = "/person")
    public ResponseEntity<Person> create(@RequestBody Person person) {
       return this._personService.save(person);
    }

    @DeleteMapping(path = "/person/{id}")
    public void delete(@PathVariable Long id) {
       this._personService.delete(id);
    }

    @PutMapping(path = "/person/{id}")
    public Person put(@RequestBody Person person) {
       return this._personService.put(person);
    }
}
