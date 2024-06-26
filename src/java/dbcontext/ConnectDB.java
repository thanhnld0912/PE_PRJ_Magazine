/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbcontext;

/**
 *
 * @author HELLO
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectDB {
    private static ConnectDB instance;
    public ConnectDB(){}
    public Connection openConnection() throws Exception{
        String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=PRJ301_DE180280;User=sa;Password=abc123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;    
    }
    public static ConnectDB getInstance(){
        if (instance == null) instance = new ConnectDB();
        return instance;
    }
}
