package vn.carforyou.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	String serverName = "localhost";
	String dbName = "cardb";
	String portNumber = "1433";
	String instance = "";
	String userID = "sa";
	String password = "123123";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBconnect().getConnection());
		} catch (Exception e) {
		}
	}
}
