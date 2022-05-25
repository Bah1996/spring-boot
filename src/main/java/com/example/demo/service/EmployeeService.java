package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final com.example.demo.repository.EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee save(Employee employee){ //Malumotlarni saqlash
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id){ //Malumotlarni id bo'yicha olish
        Optional<Employee>optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Employee>findAll(String name, String lastName ){ //Barcha malumotlarni olish
        List<Employee>employees= employeeRepository.findAll(name, lastName);
        return employees;
    }

    public List<Employee>getAll(String name, String lastName){ //Barcha malumotlarni olish
        List<Employee>employees= employeeRepository.findAllByNameAndLastName(name,lastName);
        return employees;
    }
    public List<Employee>byAll(String name){///Native qury
        List<Employee>employees=employeeRepository.getAll(name);
        return employees;
    }

    public List<Employee>likeAll(String name){
        List<Employee>employees=employeeRepository.findAllByNameEndingWith(name);
        return employees;
    }

    public  void delete(Long id){ //Malumotlarni id bo'yicha o'chirish
        employeeRepository.deleteById(id);
    }
}
