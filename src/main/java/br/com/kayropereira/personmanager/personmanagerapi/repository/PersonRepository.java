package br.com.kayropereira.personmanager.personmanagerapi.repository;

import br.com.kayropereira.personmanager.personmanagerapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    JpaRepository
    Interface que cuida e simplifica o acesso ao banco. Não necessita a abrir/
    fechar conexões. As implementações do CRUD e outras implementação também
    já são disponibilizadas.
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
}
