package com.felipe.people.controller;

import com.felipe.people.dto.request.PersonRequestDTO;
import com.felipe.people.dto.response.PersonResponseDTO;
import com.felipe.people.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id")  Long id){

       return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PersonResponseDTO>> findAll(){

        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> register (@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriComponentsBuilder){

       PersonResponseDTO personResponseDTO = personService.resgister(personRequestDTO);
       URI uri = uriComponentsBuilder.path("/people/{id}")
               .buildAndExpand(personResponseDTO)
               .toUri();

       return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personRequestDTO, @PathVariable(name = "id") Long id ){
        return ResponseEntity.ok().body(personService.update(personRequestDTO, id));
    }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
       return ResponseEntity.ok().body(personService.delete(id));
   }

}
