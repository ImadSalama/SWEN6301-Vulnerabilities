package sql_injection;

public class Constants {

    protected final static String DB_DRIVER = "org.sqlite.JDBC";
    protected final static String DB_PATH = "jdbc:sqlite:database.db";
    protected final static String COMMAND = "select * from user where username=";
    protected final static String COLUMN_NAME = "username";

}
