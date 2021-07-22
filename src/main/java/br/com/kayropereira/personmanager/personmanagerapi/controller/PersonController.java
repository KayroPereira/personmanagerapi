package br.com.kayropereira.personmanager.personmanagerapi.controller;

import br.com.kayropereira.personmanager.personmanagerapi.dto.request.PersonDTO;
import br.com.kayropereira.personmanager.personmanagerapi.dto.response.MessageResponseDTO;
import br.com.kayropereira.personmanager.personmanagerapi.exceptioin.PersonNotFoundException;
import br.com.kayropereira.personmanager.personmanagerapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired)) //Injeção de dependência no construtor de forma reduzida
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Retornar o código 201 em caso de sucesso
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletetById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}