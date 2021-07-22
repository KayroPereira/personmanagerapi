package br.com.kayropereira.personmanager.personmanagerapi.mapper;

import br.com.kayropereira.personmanager.personmanagerapi.dto.request.PersonDTO;
import br.com.kayropereira.personmanager.personmanagerapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //Obrigatório ser toModel para realizar a conversão para o banco de dados
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy") //Informa que deverá converter o formato da data de String para dateformat
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
