package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Employe;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/save")
    public Employe saveEmployee(@RequestBody Employe employe) {
        return employeeService.saveEmployee(employe);
    }

    @GetMapping("/{id}")
    public ResponseDTO getEmployeById(@PathVariable Integer id) {
        return employeeService.getEmployeeByID(id);
    }
}
