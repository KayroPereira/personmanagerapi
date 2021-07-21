package br.com.kayropereira.personmanager.personmanagerapi.controller;

import br.com.kayropereira.personmanager.personmanagerapi.dto.response.MessageResponseDTO;
import br.com.kayropereira.personmanager.personmanagerapi.entity.Person;
import br.com.kayropereira.personmanager.personmanagerapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Retornar o código 201 em caso de sucesso
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    //    Versão de chamada dos métodos dentro do controller - não é uma boa prática
//    private PersonRepository personRepository;
//
//    //Injeção de dependência - Classe PersonRepository
//    /*
//        Fazer a injeção no construtor facilita no futuro a implementação
//        de testes unitários utilizando moke
//     */
//    @Autowired
//    public PersonController(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    //@RequestBoby informa que o objeto está vindo de uma requisição
//    /*
//    modelo para teste de cadastro
//    {
//        "firstName": "Kayro",
//        "lastName": "Pereira",
//        "cpf": "009.996.184-90",
//        "phones":[
//            {
//                "type": "MOBILE",
//                "number": "(81)98277-1743"
//            }
//        ]
//    }
//    */
////    @PostMapping
////    public MessageResponseDTO createPerson(@RequestBody Person person){
////        Person savePerson = personRepository.save(person);
////        return MessageResponseDTO
////                .builder()
////                .message("Criada pessoa com Id " + savePerson.getId())
////                .build();
////    }
}