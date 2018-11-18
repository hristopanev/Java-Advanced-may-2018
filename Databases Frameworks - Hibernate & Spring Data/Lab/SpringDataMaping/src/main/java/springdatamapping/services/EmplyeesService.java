package springdatamapping.services;

import springdatamapping.dtos.EmployeeDTO;

import java.util.List;

public interface EmplyeesService {
    List<EmployeeDTO> getAllEmployees();
}
