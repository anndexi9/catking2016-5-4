package catking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    //local DB
    String url = "jdbc:postgresql://192.168.56.101:5432/catking";
	String user = "";
	String password = "";
    
   
    public Connection getConnection() throws SQLException, 
    ClassNotFoundException {
    	Class.forName("org.postgresql.Driver");
        Connection connection = 
            DriverManager.getConnection(url, user, password);
        return connection;
    }   


}
