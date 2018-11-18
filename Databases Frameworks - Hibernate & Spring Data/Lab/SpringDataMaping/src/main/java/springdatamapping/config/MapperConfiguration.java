package springdatamapping.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springdatamapping.domain.entities.Department;
import springdatamapping.domain.entities.Employee;
import springdatamapping.dtos.DepartmentDTO;
import springdatamapping.dtos.EmployeeDTO;

import javax.transaction.Transactional;
import java.util.Set;

@Transactional
@Configuration
public class MapperConfiguration {

    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper = new ModelMapper();
        mapper.createTypeMap(Employee.class, EmployeeDTO.class)
                .addMapping(
                        entity -> entity.getDepartment().getName(),
                        EmployeeDTO::setDepartment
                );



   /*     mapper.createTypeMap(Department.class, DepartmentDTO.class)
                .addMappings(mapper ->
                        mapper
                        .when(ctx -> ctx.getSource() != null)
                        .map(
                                src -> {
                                    return src.getEmployees().size();
                                },
                                DepartmentDTO::setEmployeesCount
                        ));*/
        mapper.validate();
    }





    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }
}
