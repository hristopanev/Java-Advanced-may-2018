package springdatamapping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatamapping.domain.entities.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
