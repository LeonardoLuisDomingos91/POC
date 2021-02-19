package br.com.domingos.apirestfull.service;

import br.com.domingos.apirestfull.domain.entity.Employee;
import br.com.domingos.apirestfull.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(final Employee employee) {
        employeeRepository.save(employee);
    }
}
