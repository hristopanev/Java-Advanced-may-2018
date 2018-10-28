package Demo;

import Demo.repositories.EmployeesDataRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String conncectionString = "jdbc:mysql:localhost:3306/soft_uni";

        Connection connection =
                DriverManager.getConnection(conncectionString, "root", "1234");


        EmployeesDataRepository repository =
                new EmployeesDataRepository(connection) {

                };

        repository.getAll()
        .stream()
        .map(employee -> employee.getFirstName()
        ).forEach(System.out::println);


        connection.close();
    }
}