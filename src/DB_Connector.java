import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

    private static Connection con = null; //declare a connection
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //JDBC driver
    private static String url = "jdbc:mysql://localhost:3306/"; //The URL = jdbc:dbms//host name:port#/db name
    private static String usr = "root"; //user name
    private static String pswrd = "Password2533"; //password

    public static Connection connect(){
        System.out.println("\n--Connecting to MySQL JDBC--");

        //Locate MySQL JDBC Driver
        try{
            Class.forName(DRIVER);
        }
        //Catch exceptions if JDBC is not found
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println("\n--JDBC driver is missing--");
        }
        System.out.println("\n--MySQL JDBC driver registered--");

        //Connection to MySQL DB = URL, Username, password
        try{
            con = DriverManager.getConnection(url, usr, pswrd);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("\n--Did not connect, try again--");
        }
        // if connection successful
        if(con !=null){
            System.out.println("\n--Connection successful--");
        }
        else{
            System.out.println("\n--Failed to connect--");
        }
    return con;
    }
}
