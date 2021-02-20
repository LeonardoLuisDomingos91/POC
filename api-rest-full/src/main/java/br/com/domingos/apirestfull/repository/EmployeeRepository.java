package br.com.domingos.apirestfull.repository;

import br.com.domingos.apirestfull.domain.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
