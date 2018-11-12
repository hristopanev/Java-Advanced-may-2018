package app;


import app.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void run() {
        // p02 removeObject();
        // p03 this.containsEmployee();
        // p04 employeeWithSalaryOver();
        // p05 employeesFromDepartment();
        // p06 this.addingNewAddressAndUpdatingEmployee();
        // p07 addressesWithEmployeeCount();
        // p08 getEmployeeWithProject();
        // p09 findLastTenProjects();
        // p10 increaseSalaries();
        // p12 findEmployeesByFirstName();
        // p13 employeesMaximumSalaries();
    }

    /**
     * 2.	Remove Objects
     */

    void removeObject(){


        this.entityManager.getTransaction().begin();

        List<Town> townList = entityManager
                .createQuery("SELECT t FROM Town AS t WHERE length(t.name) > 5", Town.class)
                .getResultList();

        for (Town town : townList) {
            entityManager.detach(town);
            town.setName(town.getName().toLowerCase());
            entityManager.merge(town);
        }


        this.entityManager.getTransaction().commit();
    }


    /**
     * 3.	Contains Employee
     */

    private void containsEmployee(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE concat(first_name, ' ', last_name) = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
            System.out.println("Yes");
        }catch (NoResultException nre){
            System.out.println("No");
        }


    }


    /**
     *  4.	Employees with Salary Over 50 000
     */
    private void employeeWithSalaryOver(){

            this.entityManager.getTransaction().begin();

            List<Employee> employeeList = entityManager
                    .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                    .getResultList();

       for (Employee employee : employeeList) {
           System.out.println(String.format(employee.getFirstName()));
       }



        this.entityManager.getTransaction().commit();

    }

    /**
     * 5.	Employees from Department
     */

    private void employeesFromDepartment(){

        this.entityManager.getTransaction().begin();

        List<Employee> result = entityManager
                .createQuery("FROM Employee AS e WHERE e.department.name = 'Research and Development' ORDER BY e.salary ASC, e.id ASC", Employee.class)
                .getResultList();

        for (Employee employee : result) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(), employee.getLastName(), employee.getDepartment().getName(), employee.getSalary());
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     *  6.	Adding a New Address and Updating Employee
     */

    private void addingNewAddressAndUpdatingEmployee(){
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");

        Town town = this.entityManager
                .createQuery("FROM Town WHERE name = 'Sofia'", Town.class)
                .getSingleResult();
        address.setTown(town);
        this.entityManager.persist(address);


        Employee employee = this.entityManager
                .createQuery("FROM Employee WHERE last_name = :name", Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();

        this.entityManager.detach(employee.getAddress());
        employee.setAddress(address);
        this.entityManager.merge(employee);

        this.entityManager.getTransaction().commit();
    }


    /**
     * 7.	Addresses with Employee Count
     */

    private void addressesWithEmployeeCount(){


        this.entityManager.getTransaction().begin();

        List<Address> result = entityManager
                .createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC, a.town.id", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : result) {
            System.out.printf("%s, %s - %d employees%n",
                    address.getText(), address.getTown().getName(), address.getEmployees().size());
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 8.	Get Employee with Project
     */

    private void getEmployeeWithProject(){

        Scanner scanner = new Scanner(System.in);
        int inputId = Integer.parseInt(scanner.nextLine());

        this.entityManager.getTransaction().begin();

        Employee found = entityManager
                .createQuery("select e from Employee  AS e where e.id = ?", Employee.class)
                .setParameter(0, inputId)
                .getSingleResult();

        Set<Project> employeesProjects = (Set<Project>) found.getProjects()
                .stream()
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toSet());

        System.out.printf("%s %s - %s%n", found.getFirstName(), found.getLastName(), found.getJobTitle());

        for (Project employeesProject : employeesProjects) {
            System.out.printf("\t%s%n", employeesProject.getName());
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 9.	Find Latest 10 Projects
     */

    private void findLastTenProjects(){

        entityManager.getTransaction().begin();

        List<Project> projects = entityManager
                .createQuery("select p from Project  AS p order by p.startDate desc ", Project.class)
                .setMaxResults(10)
                .getResultList();

        for (Project project : projects) {
            System.out.printf("Project name: %s%n\tProject Description: %s%n\tProject Start Date: %s%n\tProject End Date: %s%n",
                    project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
        }


        entityManager.getTransaction().commit();

    }

    /**
     * 10.	Increase Salaries
     */

    private void increaseSalaries(){

        this.entityManager.getTransaction().begin();

        List<Employee> employeeList = entityManager
                .createQuery("select e from Employee e where e.department.name in('Engineering', 'Tool Design','Marketing', 'Information Services')", Employee.class)
                .getResultList();

        employeeList.forEach(e -> {
            e.setSalary(e.getSalary().multiply(new BigDecimal(1.12)));
            entityManager.persist(e);
        });

        for (Employee employee : employeeList) {
            System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }

        this.entityManager.getTransaction().commit();

    }

    /**
     * 12.	Find Employees by First Name
     */
    private void findEmployeesByFirstName(){

        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();

        entityManager.getTransaction().begin();

        List<Employee> employeeList = entityManager
                .createQuery("select e from Employee  AS e where e.firstName = :name ", Employee.class)
                .setParameter("name", inputName)
                .getResultList();

        for (Employee employee : employeeList) {
            System.out.printf("%s %s - %s - ($%.2f)%n", employee.getFirstName(), employee.getLastName(),
                    employee.getJobTitle(), employee.getSalary());
        }

        entityManager.getTransaction().commit();
    }


    /**
     * 13.	Employees Maximum Salaries
     */

    private void employeesMaximumSalaries(){

        entityManager.getTransaction().begin();

        List<Employee> employeeList = entityManager
                .createQuery("select  e from Employee e where e.salary not between 30000 and 70000", Employee.class)
                .getResultList();

        for (Employee employee : employeeList) {
            System.out.printf("%s - %s%n", employee.getDepartment().getName(), employee.getSalary());
        }

        entityManager.getTransaction().commit();
    }

}