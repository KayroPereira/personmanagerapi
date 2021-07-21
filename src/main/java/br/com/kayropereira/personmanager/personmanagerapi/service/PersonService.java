package br.com.kayropereira.personmanager.personmanagerapi.service;

import br.com.kayropereira.personmanager.personmanagerapi.dto.response.MessageResponseDTO;
import br.com.kayropereira.personmanager.personmanagerapi.entity.Person;
import br.com.kayropereira.personmanager.personmanagerapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Criada pessoa com Id " + savePerson.getId())
                .build();
    }
}
