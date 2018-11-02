package app;

import p02.get_Villains_Names;
import p03.Get_Minion_Name;
import p04.add_Minion;
import p05.Change_Town_Name_Casing;
import p07.Print_All_Minion_Names;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "1234";

        Properties props = new Properties();

        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", props);


        Print_All_Minion_Names engine = new Print_All_Minion_Names(connection);

        engine.run();
    }
}
