package Data;

import booking.Booking;
import java.util.ArrayList;

/**
 * @author chinfei.yap@mincom.com
 * @since 0.12
 */
public class BookingData
{
    private ArrayList<Booking> bookings = new ArrayList<Booking>(  );

    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }

    public void removeAllBookings()
    {
        bookings.clear();
    }

    public void reloadBookings()
    {
        removeAllBookings();
        loadData();
    }

    private void loadData()
    {
        final int MAX=30;

        //Room bookings
        for (int i=0;i<MAX;i++)
        {
            //TODO: Load default bookings
        }

        //Equipment bookings
        for (int i=0;i<MAX;i++)
        {
            //TODO: Load default bookings
        }
    }

    public BookingData(  )
    {
        loadData();
    }
}
