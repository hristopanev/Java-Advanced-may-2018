package springdatamapping.services;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springdatamapping.dtos.EmployeeDTO;
import springdatamapping.repository.EmployeesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmplyeesService {

    private final EmployeesRepository employeesRepository;
    private final ModelMapper mapper;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository, ModelMapper mapper){
        this.employeesRepository = employeesRepository;
        this.mapper = mapper;
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeesRepository.findAll()
                .stream()
                .map(employee -> mapper
                        .map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
