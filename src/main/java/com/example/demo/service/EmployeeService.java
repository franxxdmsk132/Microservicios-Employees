package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Employe;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    public Employe saveEmployee(Employe employe){
        return employeeRepository.save(employe);
    }
    public ResponseDTO getEmployeeByID(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Employe employe = new Employe();
        employe = employeeRepository.findById(id).get();

        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employe.getDepartmentId(),
                DepartmentDTO.class);
        DepartmentDTO departmentDTO = responseEntity.getBody();
        responseDTO.setEmploye(employe);
        responseDTO.setDepartmentDTO(departmentDTO);
return responseDTO;
    }
}
