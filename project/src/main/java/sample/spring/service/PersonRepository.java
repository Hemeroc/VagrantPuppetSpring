package sample.spring.service;

import sample.spring.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
}
