package modelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataConnection {

    public DataConnection() {
    }
    
    private static Connection conn = null;
    public static Connection getConnection() throws Exception{
        if(conn == null){
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        }
        return conn;
    }
    
    public static void closeConnection() throws Exception{
        if(conn!=null){
            conn.close();
        }
        conn = null;
    }
    
    public static PreparedStatement getStatement(String query) throws Exception {
        return getConnection().prepareStatement(query);
    }
}
