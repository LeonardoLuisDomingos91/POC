package br.com.domingos.apirestfull.service;

import br.com.domingos.apirestfull.domain.entity.EmployeeEntity;
import br.com.domingos.apirestfull.domain.enumeration.EmployeeStatus;
import br.com.domingos.apirestfull.domain.mapper.EmployeeMapper;
import br.com.domingos.apirestfull.domain.request.EmployeeRequest;
import br.com.domingos.apirestfull.domain.request.EmployeeUpdateRequest;
import br.com.domingos.apirestfull.domain.response.EmployeeResponse;
import br.com.domingos.apirestfull.exception.ResourceNotFoundException;
import br.com.domingos.apirestfull.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public void save(final EmployeeRequest employeeRequest) {
        final EmployeeEntity employeeEntity = employeeMapper.fromEmployeeRequestToEmployeeEntity(employeeRequest);
        employeeRepository.save(employeeEntity);
    }

    public EmployeeResponse findbyid(final Long id) {
       final EmployeeEntity employeeEntity = employeeRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

       return employeeMapper.fromEmployeeEntityToEmployeeResponse(employeeEntity);
    }

    public void delete(final Long id) {
        final EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        employeeRepository.delete(employeeEntity);
    }

    public EmployeeResponse update(final EmployeeUpdateRequest employeeUpdateRequest, final Long id) {
        final EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        final EmployeeEntity employeeEntityUpdate = employeeMapper.fromEmployeeUpdateRequestToEmployeeEntity(employeeEntity,employeeUpdateRequest);
        employeeRepository.save(employeeEntityUpdate);

        return employeeMapper.fromEmployeeEntityToEmployeeResponse(employeeEntity);
    }

    public void dismissedById(final Long id) {
        final EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        employeeEntity.setEmployeeStatus(EmployeeStatus.DISMISSED);

        employeeRepository.save(employeeEntity);
    }
}
