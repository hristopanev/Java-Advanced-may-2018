package Demo.repositories;

import Demo.DataRepository.DataRepository;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcDataRepository<T> implements DataRepository {
    private Connection connection = null;

    public JdbcDataRepository(Connection connection) throws SQLException {
        this.connection = connection;
    }
    @Override
    public List<T> getAll() throws SQLException {
        String queryString = "SELECT * FROM " + this.getTableName();
        PreparedStatement query =
                connection.prepareStatement(queryString);
        ResultSet resultSet = query.executeQuery();

        return toList(resultSet);
    }


    private List<T> toList(ResultSet resultSet) throws SQLException {

       List <T> list = new ArrayList<>();
        while (resultSet.next()){
            T object = this.parseRow(resultSet);

            list.add(
                    object);



        }
        return list;
    }

    protected abstract T parseRow(ResultSet resultSet) throws SQLException;


    protected abstract String getTableName();

    public  void insert(Type object) {
        String queryString = "" +
                "INSERT INTO" + this.getTableName() +
                " (" + this.getColumns() + ")"
                + "VALUES (" + this.getValues((T) object) + ")";
        //INSERT INTO this.getTableName
        //(first_name, last_name)
        //VALUES()
    }

        private String queryString;
        PreparedStatement query =
                connection.prepareStatement(queryString);



        protected abstract String getValues (T object);

        protected abstract String getColumns ();



}
