
package conecciondba;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionDBA {
    private static final String DBA="biblio_docker";
    private static final String PORT="33060";
    private static final String URL ="jdbc:mysql://localhost:"+PORT+"/"+DBA;
    private static final String USER="root";
    private static final String PASSWORD="root";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connected");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
            System.out.println("not connected");
        }
        return connection;

    }
}
