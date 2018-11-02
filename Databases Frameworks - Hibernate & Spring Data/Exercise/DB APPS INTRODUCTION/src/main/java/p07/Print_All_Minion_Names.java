package p07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Print_All_Minion_Names implements Runnable {

    private Connection connection;

    public Print_All_Minion_Names(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        this.Print_All_Minion_Names();
    }

    public void Print_All_Minion_Names() {

        String getminionsNameQuery = "SELECT name FROM  minions";

        try (PreparedStatement preparedStatement = connection.prepareStatement(getminionsNameQuery)){

            List<String> minionsName = new ArrayList<>();

            ResultSet resultSet = preparedStatement.executeQuery(getminionsNameQuery);

            while (resultSet.next()){
                minionsName.add(resultSet.getString("name"));
            }

            for (int i = 0; i < minionsName.size() / 2; i++) {
                System.out.println(minionsName.get(i));
                System.out.println(minionsName.get(minionsName.size() - i - 1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
