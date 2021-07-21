package br.com.kayropereira.personmanager.personmanagerapi.controller;

import br.com.kayropereira.personmanager.personmanagerapi.dto.response.MessageResponseDTO;
import br.com.kayropereira.personmanager.personmanagerapi.entity.Person;
import br.com.kayropereira.personmanager.personmanagerapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    //Injeção de dependência - Classe PersonRepository
    /*
        Fazer a injeção no construtor facilita no futuro a implementação
        de testes unitários utilizando moke
     */
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //@RequestBoby informa que o objeto está vindo de uma requisição
    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Criada pessoa com Id " + savePerson.getId())
                .build();
    }
}