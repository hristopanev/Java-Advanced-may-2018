package WorkShop;

import WorkShop.db.base.DbContext;
import WorkShop.db.EntityDbContext;
import WorkShop.entities.Department;
import WorkShop.entities.User;

import java.sql.*;

public class App {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/softuni";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
       // Connection connection = getConnection();

        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);

        DbContext<User> usersDbContext =
                getDbContext(connection, User.class);

        DbContext<Department> departmentDbContext =
                getDbContext(connection, Department.class);

    //   DbContext<Department> departmentDbContext =
    //           getDbContext(connection, Department.class);

   //     User Ivan = new User("Ivan", "Ivanov");

    //    usersDbContext.persist(Ivan);

 //       User user = new User();


//      User user = new User("Pesho", "Peshev");
//      user.setAge(25);
//      user.setUcn("1234567890");

 //      User pena = new User("Pena", "Penewa");

   //    usersDbContext.persist();
 //       usersDbContext.persist(pena);

 //    usersDbContext.delete("first_name LIKE ('P%')");

//        User pesho = usersDbContext.findById(1);
//        pesho.setLastName("PESHEV");
//
//        usersDbContext.persist(pesho);
//
//       usersDbContext.find()
//              .forEach(System.out::println);
//      User user = usersDbContext.findFirst();
//      System.out.println(user);
//      user.setLastName("Wse taq");


//      usersDbContext.persist(user);
//              DbContext<User> userDbContext
//              = getDbContext(connection, User.class);
//      departmentDbContext.find()
//              .forEach(System.out::println);

        connection.close();
    }

    private static <T> DbContext<T> getDbContext(Connection connection, Class<T> klass) throws SQLException {
        return new EntityDbContext<>(connection, klass);
    }

   //private static Connection getConnection() throws SQLException {
   //    return DriverManager.getConnection(
   //            CONNECTION_STRING,
   //            "root",
   //            "1234"
   //    );
   //}
}
