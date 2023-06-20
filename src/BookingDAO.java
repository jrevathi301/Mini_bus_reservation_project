
import java.util.Date;
import java.sql.*;

public class BookingDAO {
    public int getbookedcount(int busno, Date date) throws SQLException {
        String query="select count(pname) from booking where bus_no=? and travel_date=?";
        Connection con = DBconnection.getconnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setInt(1,busno);
        pst.setDate(2,sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void addbooking(Booking booking) throws SQLException {
        String query="insert into booking values(?,?,?)";
        Connection con = DBconnection.getconnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busno);
        pst.setDate(3,sqldate);

        pst.executeUpdate();
    }
}
