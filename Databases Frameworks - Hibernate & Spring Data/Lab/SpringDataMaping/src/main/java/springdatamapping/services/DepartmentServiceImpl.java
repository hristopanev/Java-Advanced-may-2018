package springdatamapping.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springdatamapping.dtos.DepartmentDTO;
import springdatamapping.repository.DepartmentsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentsRepository departmentsRepository;
    private final ModelMapper mapper;

    public DepartmentServiceImpl(DepartmentsRepository departmentsRepository, ModelMapper mapper) {
        this.departmentsRepository = departmentsRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        return  departmentsRepository.findAll()
                .stream()
                .map(department -> mapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());


/*        return departmentsRepository.findAll()
                .stream()
                .map(department -> {
                    DepartmentDTO dto = new DepartmentDTO();
                    dto.setName(department.getName());
                    dto.getEmployeesCount(department.getEmployees().size());
                    return dto;
                }).collect(Collectors.toList());*/
    }
}
