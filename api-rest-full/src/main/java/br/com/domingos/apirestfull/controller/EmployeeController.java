package br.com.domingos.apirestfull.controller;

import br.com.domingos.apirestfull.domain.request.EmployeeRequest;
import br.com.domingos.apirestfull.domain.request.EmployeeUpdateRequest;
import br.com.domingos.apirestfull.domain.response.EmployeeResponse;
import br.com.domingos.apirestfull.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final EmployeeRequest employeeRequest) {
        employeeService.save(employeeRequest);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable("id") final Long id) {
        final EmployeeResponse employeeResponse = employeeService.findbyid(id);
        return ResponseEntity.ok(employeeResponse);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        employeeService.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public EmployeeResponse update(@RequestBody final EmployeeUpdateRequest employeeUpdateRequest, @PathVariable("id") final Long id) {
        return employeeService.update(employeeUpdateRequest, id);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dismissed(@PathVariable("id") final Long id) {
        employeeService.dismissedById(id);
    }

}
