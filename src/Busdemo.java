import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Busdemo {
    public static void main(String[] args)  {
        BusDAO busdao=new BusDAO();
        try {
            busdao.displayinfo();

            int userinput = 1;
            Scanner sc = new Scanner(System.in);

            while (userinput == 1) {
                System.out.println("enter 1 to book and 2 to exit");
                userinput = sc.nextInt();
                if (userinput == 1) {
                    Booking booking = new Booking();
                    if (booking.isAvalable()) {
                        BookingDAO bookingdao = new BookingDAO();
                        bookingdao.addbooking(booking);
                        System.out.println("your booking is confirmed");
                    } else {
                        System.out.println("sorry.. bus if full .try another bus or date");
                    }
                }
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
