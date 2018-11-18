package springdatamapping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdatamapping.domain.entities.Department;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Long> {
}
