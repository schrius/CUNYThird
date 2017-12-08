package Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * JDBC class connect to SQL.
 * responsible for connection, statement execution.
 */
public class RegisterJDBC {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@DathanPC:1521:xe";
	static final String DB_USER = "cisc3810";
	static final String DB_PASS = "cisc3810";
	String sqlStatement = "";
	public static Connection connection;
	public static Statement statement;
	public static ResultSet result;

	public RegisterJDBC(){
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			statement = connection.createStatement();
		}
		catch (SQLException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void connect() throws ClassNotFoundException{
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			System.out.println("Oracle Database connected!");
			System.out.println("Loading...");
			statement = connection.createStatement();
			System.out.println("Loading complete...");
		}
		catch (SQLException e) {
			e.getStackTrace();
		}
	}

	public static void excuteSQL(String sql) throws SQLException{
		result = statement.executeQuery(sql);
	}

	public static void closeSQL() throws SQLException{
		try {
			if(connection !=null || !connection.isClosed()){
				connection.close();
			if(statement != null || !statement.isClosed())
				statement.close();
			if(result != null || !result.isClosed())
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection !=null || !connection.isClosed())
				connection.close();
			if(statement != null || !statement.isClosed())
				statement.close();
			if(result != null || !result.isClosed())
				result.close();
		}
	}
}
