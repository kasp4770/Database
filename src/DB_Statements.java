import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;      //Or: "import java.sql.*" to import all java.sql classes
import java.sql.Statement;

public class DB_Statements { //------------------HARDCODE----------------------//

    //Declare a Statement
    private static Statement stmt = null;

    //Declare a connection
    private static Connection con = DB_Connector.connect();

    //Declare a result set
    private static ResultSet rs = null;

    //Method to create a new Database
    public void createNewDB(String DB_Name){
        //SQL statement (Connection -- execute statement)
        String query = "create database if not exists " + DB_Name;

        try{
            //connection
            stmt = con.createStatement();
            //execute statement
            stmt.executeUpdate(query);
            System.out.println("\n--Database" + DB_Name +" created--");
        }
        catch(SQLException ex){
            //handle sql exceptions
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }
    }

    //Method to use a database
    public void useDB(String DB_Name){
        //statement
        String query = "use " + DB_Name;
        try {
            //connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            System.out.println("\n--Using" + DB_Name + "--");
        }
        catch (SQLException ex){
            //handle sql exception
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    public void createTable(String tableName){
        //statement
        String query = "create table if not exists " + tableName +
                "(" +
                "id int not null auto_increment, " +
                "myName varchar(28), " +
                "adress varchar(28), " +
                "primary key(id)" +
                ")";
        try {
            //connection
            stmt = con.createStatement();
            //execute
            stmt.executeUpdate(query);
            System.out.println("\n--Table " + tableName + " created--");
        }
        catch (SQLException ex){
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    public void insertData(String tableName){
        //statement
        String query = "insert into " + tableName + "(" +
                "myName, " +
                "adress) " +
                "values('Kasper', 'My adress'), " +
                "('Jesper', 'Villavej'), " +
                "('Mogens', 'Slumalle')";
        try {
            //connection
            stmt = con.createStatement();
            //execute
            stmt.executeUpdate(query);
            System.out.println("\n--Successfully inserted data into " + tableName + "--");
        }
        catch (SQLException ex){
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    public void selectFromTable(String tableName){
        //statement
        String query = "select * from " + tableName;

        try{
            //connection
            stmt = con.createStatement();
            //execute
            rs = stmt.executeQuery(query);
            System.out.println("\nid\t\tmyName\t\tadress\n___________________________________");

            //get data
            while(rs.next()){
                int id = rs.getInt(1); //returns the id
                String myName = rs.getString("myName"); //returns myName column
                String adress = rs.getString("adress");
                System.out.println(id + "\t\t" + myName + "\t\t" + adress);
            }

        }
        catch (SQLException ex){
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    public boolean checkLogin(String username, String password){
        boolean check = false;
        String query = "select * from thisdatabase.user where username = '" + username + "' and password = '" +
                password + "'";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                check = true;
                System.out.println("\n--Yaaaaay! It fucking WORKS!!!--");
            }
        }
        catch(SQLException e){
            System.out.println("\n--Fuck this shit...--");
            e.printStackTrace();
        }
        return check;
    }
}
