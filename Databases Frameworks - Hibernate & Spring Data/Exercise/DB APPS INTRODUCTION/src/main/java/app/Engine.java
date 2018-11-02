package app;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

//public class Engine implements Runnable {

  //  private Connection connection;
//
  //  public Engine(Connection connection) {
  //      this.connection = connection;
//
  //  }
//
  //  public void run() {
  //     try {
  //         this.addMinion();
  //        //this.getVillainsNames();
  //     } catch (SQLException e) {
  //         e.printStackTrace();
  //     }
  //  }
//
//
//
  //  /**
  //   * Problem 4. Add Minion
  //   */
  //  private void addMinion() throws SQLException {
  //      Scanner scanner = new Scanner(System.in);
//
  //      String [] minionsParams = scanner.nextLine().split(" ");
  //      String [] villanParams = scanner.nextLine().split(" ");
//
  //      String minionName = minionsParams[1];
  //      int minionAge = Integer.parseInt(minionsParams[2]);
  //      String townName = minionsParams[3];
  //      String villanName = villanParams[1];
//
  //      if (!this.checksIfEntityExists(townName, "towns")){
  //          this.insertTown(townName);
  //      }
//
  //      if (!this.checksIfEntityExists(villanName, "villains")){
  //          this.insertVillain(villanName);
  //      }
//
  //      int townId = this.getEntityId(townName, "towns");
//
  //      this.insertMinion(minionName, minionAge, townId);
//
//
  //      int minionId = this.getEntityId(minionName, "minions");
  //      int villainId = this.getEntityId(villanName, "vallains");
//
  //      this.hireMinion(minionId, villainId);
//
  //      System.out.println(String
  //              .format("Successfully added Carry to be minion of Jimmy", minionName, minionAge, villanName));
//
  //  }
//
  //  private boolean checksIfEntityExists(String name, String tableName) throws SQLException {
  //      String query = "SELECT * FROM " + tableName +  " WHERE name = ?";
//
  //      PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//
  //      preparedStatement.setString(1, name);
  //      ResultSet resultSet = preparedStatement.executeQuery();
//
  //      if (resultSet.next()){
  //          return true;
  //      }
//
  //      return false;
  //  }
//
  //  private void insertTown(String townName) throws SQLException {
  //      String query = "INSERT INTO towns(name, country) VALUES('" + townName + "', NULL)";
  //      PreparedStatement statement = this.connection.prepareStatement(query);
//
  //      statement.executeQuery();
//
  //      System.out.println(String.format("Town %s was added to the database.", townName));
  //  }
//
  //  private void insertVillain(String villainName) throws SQLException {
  //      String query = String.format("INSERT INTO villains(name, evilness_factor) " +
  //              "VALUES('%s', 'evil')", villainName);
//
  //      PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//
  //      preparedStatement.executeQuery();
//
  //      System.out.println(String.format("Villain %s was added to the database.", villainName));
  //  }
//
  //  private int getEntityId(String name, String tableName) throws SQLException {
  //      String query = String.format("SELECT id FROM %s WHERE name = '%s'", tableName, name);
  //      PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//
  //      ResultSet resultSet = preparedStatement.executeQuery();
  //      resultSet.next();
//
  //      return resultSet.getInt(1);
  //  }
//
  //  private void insertMinion(String minionName, int age, int townId) throws SQLException {
  //      String  query = String.format("INSERT INTO minions(name, age, town_id)" +
  //              "VALUES('%s', %d, %d)", minionName, age, townId);
//
  //      PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//
  //      preparedStatement.executeQuery();
  //  }
//
  //  private void hireMinion(int minionId, int villainId) throws SQLException {
  //      String query = String.format("INSERT INTO minions_villains(minion_id, villain_id)" +
  //              "VALUES(%d, %d)", minionId, villainId);
//
  //      PreparedStatement preparedStatement = this.connection.prepareStatement(query);
  //  }
//}
