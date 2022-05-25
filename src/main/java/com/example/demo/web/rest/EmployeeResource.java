package com.example.demo.web.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){
        if(employee.getId()==null){
            return ResponseEntity.badRequest().build();
        }
        Employee result =employeeService.save(employee);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee>getOne(@PathVariable Long id){
        Employee result = employeeService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees")
    public ResponseEntity getAll(@RequestParam String name,@RequestParam String lastName){
        List<Employee>employees=employeeService.findAll(name, lastName);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employees/search")
    public ResponseEntity getsAll(@RequestParam String name,@RequestParam String lastName){
        List<Employee>employees=employeeService.getAll(name,lastName);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employees/query")
    public ResponseEntity bysAll(@RequestParam String name){
        List<Employee>employees=employeeService.byAll(name);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employees/like")
    public ResponseEntity likeAll(@RequestParam String name){
        List<Employee>result=employeeService.likeAll(name);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }
}
