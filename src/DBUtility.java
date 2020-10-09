import java.sql.*;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F20COMP1011S1", user, password);

            //2. create a SQL string
            String sql = "INSERT INTO patients (firstName, lastName, phoneNum, birthday, streetAddress, city, province) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";

            //3. "prepare" the query
            ps = conn.prepareStatement(sql, new String[] {"id"});

            //4. bind the values to the data types
            ps.setString(1, newPatient.getFirstName());
            ps.setString(2, newPatient.getLastName());
            ps.setString(3, newPatient.getPhoneNum());
            ps.setDate(4, Date.valueOf(newPatient.getBirthday()));
            ps.setString(5, newPatient.getStreetAddress());
            ps.setString(6, newPatient.getCity());
            ps.setString(7, newPatient.getProvince());

            //5. execute the INSERT
            ps.executeUpdate();

            //6. get the patientID returned
            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next()){
                patientID = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Finally block will run even if there is an exception or not
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
            return patientID;
        }
    }
}
