package exercicio.fixacao.one.service;

import exercicio.fixacao.one.domain.Person;
import exercicio.fixacao.one.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository _personRepository;

    public List<Person> showAll() {
        return this._personRepository.findAll();
    }

    public ResponseEntity<Person> save(Person person) {
        this._personRepository.save(person);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(person.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    public void delete(Long id) {
        this._personRepository.deleteById(id);
    }

    public Person put(Person person) {
        return this._personRepository.save(person);
    }

    public Optional<Person> findById(Long id)  {
        return this._personRepository.findById(id);
    }
}
