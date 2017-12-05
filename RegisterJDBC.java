package Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterJDBC {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@//localhost:3306/cisc3810";
	static final String DB_USER = "cisc3810";
	static final String DB_PASS = "cisc3810";
	String sqlStatement = "";
	Connection connection;
	Statement statement;
	ResultSet result;
	
	public RegisterJDBC() throws SQLException, ClassNotFoundException {
		try{
			Class.forName(JDBC_DRIVER);
			this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			this.statement = connection.createStatement();
			this.sqlStatement = "SELECT * FROM Student";
			this.result = statement.executeQuery(sqlStatement);
			
		}
		catch (SQLException e) {
			e.getStackTrace();
		}
	}
	public void excuteSQL(String sql) throws SQLException{
		this.sqlStatement = sql;
		this.result = statement.executeQuery(this.sqlStatement);
	}
	
	public void closeSQL() throws SQLException{
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
	public String getSqlStatement() {
		return sqlStatement;
	}
	public void setSqlStatement(String sqlStatement) {
		this.sqlStatement = sqlStatement;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public ResultSet getResult() {
		return result;
	}
	public void setResult(ResultSet result) {
		this.result = result;
	}
}
