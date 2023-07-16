package com.felipe.people.services;

import com.felipe.people.dto.request.PersonRequestDTO;
import com.felipe.people.dto.response.PersonResponseDTO;
import com.felipe.people.entity.Person;
import com.felipe.people.repository.PersonRepository;
import com.felipe.people.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImplement implements PersonService {


    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {
        return personMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO resgister(PersonRequestDTO personDTO) {

       Person person = personMapper.toPerson(personDTO);
       return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personRequestDTO, Long id) {
        Person person = returnPerson(id);
       personMapper.updatePersonData(person, personRequestDTO);
       return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Person id: "+id+" deleted";
    }

    private Person returnPerson(Long id){
        return personRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Person not found"));
    }
}
