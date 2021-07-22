package br.com.kayropereira.personmanager.personmanagerapi.service;

import br.com.kayropereira.personmanager.personmanagerapi.dto.request.PersonDTO;
import br.com.kayropereira.personmanager.personmanagerapi.dto.response.MessageResponseDTO;
import br.com.kayropereira.personmanager.personmanagerapi.entity.Person;
import br.com.kayropereira.personmanager.personmanagerapi.exceptioin.PersonNotFoundException;
import br.com.kayropereira.personmanager.personmanagerapi.mapper.PersonMapper;
import br.com.kayropereira.personmanager.personmanagerapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired)) //Injeção de dependência no construtor de forma reduzida
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);
        return createMessageResponse(savePerson.getId(), "Criado pessoa com Id ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatePerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatePerson.getId(), "Atualizado pessoa com Id ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String menssage) {
        return MessageResponseDTO
                .builder()
                .message(menssage + id)
                .build();
    }
}
