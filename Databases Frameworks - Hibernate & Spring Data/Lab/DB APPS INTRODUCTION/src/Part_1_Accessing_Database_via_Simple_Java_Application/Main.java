package Part_1_Accessing_Database_via_Simple_Java_Application;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);


        PreparedStatement  stmt = connection.prepareStatement
                ("SELECT first_name, last_name FROM employees WHERE salary > ?");

        String salary = scanner.next();

        stmt.setDouble(1, Double.parseDouble(salary));

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("first_name")+ " "
                    + rs.getString("last_name"));
        }

    }
}
