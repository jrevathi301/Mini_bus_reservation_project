import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busno;
    Date date;

    public Booking() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name:");
        passengerName = sc.next();

        System.out.println("Enter bus no:");
        busno = sc.nextInt();

        System.out.println("enter the date in dd-mm-yyy");
        String dateinput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        try {
            date = dateFormat.parse(dateinput);
        }
        catch (ParseException e){
            e.printStackTrace();
        }

    }

    public boolean isAvalable() throws SQLException {
        BusDAO busdao=new BusDAO();
        BookingDAO bookingdao=new BookingDAO();
        int capacity = busdao.getcapacity(busno);

        int booked=bookingdao.getbookedcount(busno,date);

        return booked<capacity?true:false;
    }

}
