import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.text.LayoutQueue;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("softuni");

        EntityManager entityManager = factory.createEntityManager();

        Person[] people =
                {
                        new Student("Pesho" + Math.random(), 3),
                        new Teacher("Gosho" + Math.random(), "Java")
                };
        inTransaction(
                entityManager,
                () -> Arrays.stream(people)
                        .forEach(entityManager::persist)
        );

        Mother mother = new Mother("Gina" + Math.random());
        mother.setChild(people[1]);

        inTransaction(
                entityManager,
                () -> entityManager.persist(mother)
        );



/*        Department department = new Department("Engineering");

        Employee employee = new Employee("Gesho", new Date());

        employee.setDepartment(department);

        inTransaction(entityManager,
                () -> entityManager.persist(employee));*/


/*        Project project = entityManager.find(Project.class, 28);
        Employee employee = project.getEmployees()
                .stream()
                .findAny()
                .orElse(null);


        employee.getProject()
                .stream()
                .map(Project::getName)
                .forEach(System.out::println);*/


       /* List<Employee> employees = List.of(
                new Employee("Gosho 1", new Date()),
                new Employee("Gosho 2", new Date()),
                new Employee("Gosho 3", new Date()),
                new Employee("Gosho 4", new Date()),
                new Employee("Gosho 5", new Date())
        );

        Project project = new Project("univers");

        project.setEmployees(new HashSet<>(employees));

        inTransaction(
                entityManager,
                ()-> entityManager.persist(project)
        );*/

     /*   Department department = entityManager.find(Department.class, 12);
        department.getEmployees()
                .forEach(System.out::println);*/


     /*   Employee employee = entityManager.find(Employee.class, 11);
        System.out.println(employee.getName());
        System.out.println(employee.getDepartment().getName());*/



       /* Mother mother1 = entityManager.find(Mother.class, 5);
        System.out.println(mother1.getName());
        System.out.println(mother1.getChild().getName());*/


       /* List<Teacher> result = entityManager.createQuery("from teachers", Teacher.class)
                .getResultList();

        result
                .forEach(System.out::println);*/

         /*CriteriaBuilder builder = entityManager.getCriteriaBuilder();

         CriteriaQuery<Teacher> criteriaBuilder =
                 builder.createQuery(Teacher.class);

         criteriaBuilder.from(Teacher.class);

         entityManager.createQuery(criteriaBuilder)
                 .getResultList()
                 .forEach(System.out::println);*/
    }


    static void inTransaction(EntityManager entityManager, Runnable runnable) {

        entityManager.getTransaction().begin();

        runnable.run();

        entityManager.getTransaction().commit();
    }
}
