package br.com.kayropereira.personmanager.personmanagerapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data       //Gera automaticamente gets, sets, equals, hascode
@Builder    //Ajuda na criação da classe. Auxilia na criação de testes unitários
public class MessageResponseDTO {

    private String message;
}
