package Part_2_Writing_your_own_data_retrieval_application;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt = connection.prepareStatement("SELECT\n" +
                "       u.user_name,\n" +
                "       u.first_name,\n" +
                "       u.last_name,\n" +
                "       COUNT(ug.id) AS 'played_games'\n" +
                "FROM users AS u\n" +
                "       JOIN users_games AS ug\n" +
                "         ON u.id = ug.user_id\n" +
                "WHERE u.user_name LIKE (?) ");


        String userName = scanner.next();

        stmt.setString(1, userName);


        ResultSet rs = stmt.executeQuery();



     // if (rs =){
     //     System.out.println("No such user exists");
     // }

        while (rs.next()){

            System.out.println("User: " + rs.getString("user_name") + "\n"
            + rs.getString("first_name") + " "
                   + rs.getString("last_name") + " "
            + "has played" + " " + rs.getString("played_games") + " " + "games");
        }



    }
}
