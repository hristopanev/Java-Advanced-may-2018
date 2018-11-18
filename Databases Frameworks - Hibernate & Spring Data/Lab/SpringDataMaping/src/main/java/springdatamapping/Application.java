package springdatamapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdatamapping.dtos.DepartmentDTO;
import springdatamapping.services.DepartmentService;
import springdatamapping.services.EmplyeesService;

import java.util.List;

@Component
public class Application implements CommandLineRunner {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmplyeesService emplyeesService;

    @Override
    public void run(String... args) throws Exception {
        List<DepartmentDTO> list = departmentService.getAllDepartment();
        list.forEach(System.out::println);

        System.out.println("----------------------------");

        emplyeesService.getAllEmployees()
                .forEach(System.out::println);

        //Identical
        /*departmentService.getAllDepartment()
                .forEach(System.out::println);*/
    }
}
