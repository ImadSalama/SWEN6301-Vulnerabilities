package sql_injection;

import java.sql.*;

public class SQLExecutorWithPrevention extends SQLExecutor{

    public SQLExecutorWithPrevention(){
        this.sqlReader = new SQLReader();
    }

    @Override
    public void execute() {
        Connection connection = this.createConnection();
        String username = this.sqlReader.readCommand();
        try{
            ResultSet resultSet = this.executeQuery(connection, Constants.COMMAND, username);
            this.printResultSet(resultSet);
            this.closeConnection(connection);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(Connection connection, String SQLCommand, String username) throws SQLException {
        SQLCommand = SQLCommand + "?";
        PreparedStatement statement = connection.prepareStatement(SQLCommand);
        statement.setString(1, username);
        return statement.executeQuery();
    }

}
