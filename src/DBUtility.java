import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtility {
    private static String user = "root";
    private static String password = "";

    //This method receives a new patient object, adds it to the database and returns the id
    public static int insertNewPatient(Patient newPatient) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int patientID = -1;

        try {
            //1. connect to the database
            //2. create a SQL string
            //3. "prepare" the query
            //4. bind the values to the data types
            //5. execute the INSERT
            //6. get the patientID returned
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Finally block will run even if there is an exception or not
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
        }
    }
}
