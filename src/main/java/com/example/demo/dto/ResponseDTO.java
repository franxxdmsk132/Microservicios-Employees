package com.example.demo.dto;


import com.example.demo.entity.Employe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Employe employe;
    private DepartmentDTO departmentDTO;
}
