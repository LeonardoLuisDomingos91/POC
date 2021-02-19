package br.com.domingos.apirestfull.controller;

import br.com.domingos.apirestfull.domain.entity.Employee;
import br.com.domingos.apirestfull.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Employee employee) {
        employeeService.save(employee);
    }

}
