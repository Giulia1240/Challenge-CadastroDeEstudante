package acc.br.sap_university.security.domain.dto;

import acc.br.sap_university.security.domain.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role){
}
