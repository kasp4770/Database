import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {

        //DB_Connector.connect();

        DB_Statements stmts = new DB_Statements();
        stmts.createNewDB();
    }
}
