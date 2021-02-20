package br.com.domingos.apirestfull.domain.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {

    private String name;

    private String middleName;

    private String lastName;

    private String celPhone;

    private String email;
}
