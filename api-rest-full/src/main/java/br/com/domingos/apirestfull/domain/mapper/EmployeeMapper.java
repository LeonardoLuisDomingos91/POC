package br.com.domingos.apirestfull.domain.mapper;

import br.com.domingos.apirestfull.domain.entity.EmployeeEntity;
import br.com.domingos.apirestfull.domain.request.EmployeeRequest;
import br.com.domingos.apirestfull.domain.request.EmployeeUpdateRequest;
import br.com.domingos.apirestfull.domain.response.EmployeeResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeEntity fromEmployeeRequestToEmployeeEntity(final EmployeeRequest employeeRequest) {
        final EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName(employeeRequest.getName());
        employeeEntity.setMiddleName(employeeRequest.getMiddleName());
        employeeEntity.setLastName(employeeRequest.getLastName());
        employeeEntity.setCelPhone(employeeRequest.getCelPhone());
        employeeEntity.setEmail(employeeRequest.getEmail());

        return employeeEntity;
    }

    public EmployeeResponse fromEmployeeEntityToEmployeeResponse(final EmployeeEntity employeeEntity) {
        final EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setName(employeeEntity.getName());
        employeeResponse.setMiddleName(employeeEntity.getMiddleName());
        employeeResponse.setLastName(employeeEntity.getLastName());
        employeeResponse.setCelPhone(employeeEntity.getCelPhone());
        employeeResponse.setEmail(employeeEntity.getEmail());

        return employeeResponse;
    }

    public EmployeeEntity fromEmployeeUpdateRequestToEmployeeEntity(final EmployeeEntity employeeEntity, final EmployeeUpdateRequest employeeUpdateRequest) {
        employeeEntity.setCelPhone(employeeUpdateRequest.getCelPhone());
        employeeEntity.setEmail(employeeUpdateRequest.getEmail());

        return employeeEntity;
    }

}
