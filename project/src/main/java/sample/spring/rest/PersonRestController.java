package sample.spring.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.spring.entity.Person;
import sample.spring.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<Person>> find() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public HttpEntity<Person> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<Person> create(@RequestParam Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public HttpEntity<Person> update(@PathVariable Long id, @RequestParam Person person) {
        person.setId(id);
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam Person person) {
        personRepository.delete(person);
    }

}
