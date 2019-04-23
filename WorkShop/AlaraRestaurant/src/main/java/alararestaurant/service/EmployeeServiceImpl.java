package alararestaurant.service;

import alararestaurant.domain.dtos.EmployeeImportDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import alararestaurant.domain.entities.Position;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEES_FILE_JSON_IMPORT = System.getProperty("user.dir") + "/src/main/resources/files/employees.json";

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEES_FILE_JSON_IMPORT);
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder importResult = new StringBuilder();
        EmployeeImportDto[] employeeImportDtos = this.gson.fromJson(employees, EmployeeImportDto[].class);

        Arrays.stream(employeeImportDtos)
                .forEach(employeeImportDto -> {

                    Position positionEntity = this.modelMapper.map(employeeImportDto, Position.class);
                    positionEntity.setName(employeeImportDto.getPosition());

                    if (!this.validationUtil.isValid(employeeImportDto)) {
                        importResult.append("Invalid data format.").append(System.lineSeparator());

                        return;
                    }


                    this.positionRepository.saveAndFlush(positionEntity);


                    Employee employeeEntity = modelMapper.map(employeeImportDto, Employee.class);
                    employeeEntity.setPosition(positionEntity);
                    this.employeeRepository.saveAndFlush(employeeEntity);

                    importResult.append(String.format("Record %s successfully imported.",
                            employeeEntity.getClass().getSimpleName(), employeeEntity.getName())).append(System.lineSeparator());


                });


        return importResult.toString().trim();
    }
}
