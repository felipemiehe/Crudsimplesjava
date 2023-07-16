package com.felipe.people.repository;

import com.felipe.people.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
