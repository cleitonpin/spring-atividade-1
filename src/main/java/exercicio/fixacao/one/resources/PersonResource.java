package exercicio.fixacao.one.resources;

import exercicio.fixacao.one.domain.Person;
import exercicio.fixacao.one.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PersonResource {

    @Autowired
    private PersonRepository _personRepository;

   @GetMapping(path = "/persons")
    public List<Person> getAll() {
       return this._personRepository.findAll();
    }

    @PostMapping(path = "/person")
    public ResponseEntity<Person> create(@RequestBody Person person) {
       this._personRepository.save(person);
       URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(person.getId()).toUri();

       return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/person/{id}")
    public void delete(@PathVariable Long id) {
       boolean isFound = this._personRepository.existsById(id);



       this._personRepository.deleteById(id);
    }
}
