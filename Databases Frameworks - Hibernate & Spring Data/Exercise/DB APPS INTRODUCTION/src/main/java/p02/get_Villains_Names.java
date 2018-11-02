package p02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class get_Villains_Names implements Runnable {

    private Connection connection;

    public get_Villains_Names(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
           this.getVillainsNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getVillainsNames() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String query = "SELECT v.name, count(m.minion_id) FROM villains AS v JOIN minions_villains AS m on v.id = m.villain_id GROUP BY v.id HAVING count(m.minion_id) > ? ORDER BY count(m.minion_id) DESC";
        PreparedStatement preparedStatement = this.connection
                .prepareStatement(query);

        preparedStatement.setInt(1, Integer.parseInt(scanner.nextLine()));

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(String.format("%s %d", resultSet
                    .getString(1), resultSet.getInt(2)));
        }
    }

}
