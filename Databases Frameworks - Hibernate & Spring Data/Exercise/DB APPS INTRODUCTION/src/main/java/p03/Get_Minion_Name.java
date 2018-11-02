package p03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Get_Minion_Name {
    private Connection connection;

    public Get_Minion_Name(Connection connection) {
        this.connection = connection;
    }

    public void run(){
        try {
            this.Get_Minion_Name();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private void Get_Minion_Name() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        int vallainId = Integer.parseInt(scanner.nextLine());
        String vallainName;

        String getVillainNameQuery = "SELECT v.name FROM villains AS v WHERE v.id = ?";

        String getMinionsQuery = "SELECT v.name, m.name, m.age FROM minions AS m JOIN minions_villains m2  on m.id = m2.minion_id\n" +
                "JOIN villains v on m2.villain_id = v.id WHERE v.id = ? ORDER BY m.name";


        try (PreparedStatement preparedStatement = connection.prepareStatement(getVillainNameQuery)){
            preparedStatement.setInt(1, vallainId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            vallainName = resultSet.getString("name");
            System.out.println("Vallian: " + vallainName);
        }catch (SQLException e){
            System.out.printf("No villain with ID %d exists in the database.", vallainId);
            return;
        }



        try (PreparedStatement preparedStatement = this.connection.prepareStatement(getMinionsQuery)){
            preparedStatement.setInt(1, vallainId);

            ResultSet resultSet = preparedStatement.executeQuery();

            int minionIndex = 0;

            while (resultSet.next()){
                String minionsName = resultSet.getString("name");
                int minonsAge = resultSet.getInt("age");

                System.out.println(String.format("%d. %s %d", ++minionIndex, minionsName, minonsAge));
            }

            if (minionIndex == 0){
                System.out.println("<no minions>");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
