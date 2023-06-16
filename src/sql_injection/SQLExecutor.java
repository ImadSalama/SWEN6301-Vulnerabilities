package sql_injection;

import java.sql.*;

public abstract class SQLExecutor {

    protected SQLReader sqlReader;

    public String readFolder(){
        System.out.println("Enter username: ");
        return this.sqlReader.readCommand();
    }

    public Connection createConnection(){
        Connection connection = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_PATH);
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    public boolean closeConnection(Connection connection) throws SQLException {
        connection.close();
        return true;
    }

    public ResultSet executeQuery(Connection connection, String SQLCommand) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(SQLCommand);
    }

    public void printResultSet(ResultSet resultSet){
        try {
            while(resultSet.next()){
                System.out.println(resultSet.getString(Constants.COLUMN_NAME));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public abstract void execute();



}
