import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//data access object
public class BusDAO {
    public void displayinfo() throws SQLException {
        String query = "select * from buses";
        Connection con = DBconnection.getconnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("bus no:" + rs.getInt(1));
            if (rs.getInt(2) == 0) {
                System.out.println("ac: no");
            } else {
                System.out.println("AC :yes");
            }
            System.out.println("capacity:" + rs.getInt(3));
        }
    }

    public int getcapacity(int id) throws SQLException {
        String query = "select capacity from buses where id=" + id;
        Connection con = DBconnection.getconnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
