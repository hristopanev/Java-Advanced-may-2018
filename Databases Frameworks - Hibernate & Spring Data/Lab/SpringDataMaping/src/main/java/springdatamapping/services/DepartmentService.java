package springdatamapping.services;

import springdatamapping.domain.entities.Department;
import springdatamapping.domain.entities.Employee;
import springdatamapping.dtos.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> getAllDepartment();
}
