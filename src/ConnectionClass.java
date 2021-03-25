import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionClass {
	Connection conn = null;
	   
	   public static Connection dbConnector() {
		   
		   try {
				Class.forName("org.sqlite.JDBC")  ;
				Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\JACKIE\\eclipse-workspace\\ConnectionClass.db");				
				  return conn;
				
			  }catch(Exception e) {
				  JOptionPane.showMessageDialog(null, e);
				  return null;
			  }
	}



}
