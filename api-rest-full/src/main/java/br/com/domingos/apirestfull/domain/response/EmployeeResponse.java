package br.com.domingos.apirestfull.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

    private String name;

    private String middleName;

    private String lastName;

    private String celPhone;

    private String email;
}
