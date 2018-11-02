package p05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Change_Town_Name_Casing implements Runnable {
    private Connection connection;

    public Change_Town_Name_Casing(Connection connection) {
        this.connection = connection;
    }



    public void run() {
        this.Change_Town_Name_Casing();
    }


    private void Change_Town_Name_Casing(){
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        String uppdateTownsQuery = "UPDATE towns SET name = UPPER(name) WHERE country = ?;";

        String getTownNameQuery = "SELECT  name FROM towns WHERE country LIKE (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(uppdateTownsQuery)){
            preparedStatement.setString(1, country);
            int rows = preparedStatement.executeUpdate();

            if (rows == 0){
                System.out.println("No town names were affected.");
            }else {
                System.out.printf("%d town names were affected. ", rows);
                System.out.println();

                PreparedStatement preparedStatement1 = connection.prepareStatement(getTownNameQuery);
                preparedStatement1.setString(1, country);
                ResultSet resultSet = preparedStatement1.executeQuery();

                List<String> townName = new ArrayList<>();

                while (resultSet.next()){
                    townName.add(resultSet.getString("name"));
                }

                System.out.println(String.format("[%s]", String.join(", ", townName)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
