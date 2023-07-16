package com.felipe.people.services;

import com.felipe.people.dto.request.PersonRequestDTO;
import com.felipe.people.dto.response.PersonResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {

    PersonResponseDTO findById(Long id);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO resgister(PersonRequestDTO personDTO);

    PersonResponseDTO update(PersonRequestDTO personDTO, Long id);

    String delete(Long id);

}
