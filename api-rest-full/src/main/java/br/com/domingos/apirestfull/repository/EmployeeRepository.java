package br.com.domingos.apirestfull.repository;

import br.com.domingos.apirestfull.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
