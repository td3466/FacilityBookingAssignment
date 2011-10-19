package facilitybookingsystem.impl.domain.Data;

import facilitybookingsystem.impl.domain.booking.Booking;
import java.util.ArrayList;

/**
 * @author chinfei.yap@mincom.com
 * @since 0.12
 */
public class BookingData
{
    private ArrayList<Booking> bookings = new ArrayList<Booking>();

    private ArrayList<Booking> roomBookings = new ArrayList<Booking>();

    private ArrayList<Booking> equipmentBookings = new ArrayList<Booking>();

    private ArrayList<Booking> memberBookings = new ArrayList<Booking>();

    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }

    public ArrayList<Booking> getRoomBookings()
    {
        return roomBookings;
    }

    public ArrayList<Booking> getEquipmentBookings()
    {
        return equipmentBookings;
    }

    public ArrayList<Booking> getMemberBookings()
    {
        return memberBookings;
    }

    public void removeAllBookings()
    {
        bookings.clear();
        roomBookings.clear();
        equipmentBookings.clear();
        memberBookings.clear();
    }

    public void reloadBookings()
    {
        removeAllBookings();
        loadData();
    }

    private void loadData()
    {
        final int MAX = 30;

        //Room bookings
        for( int i = 0; i < MAX; i++ )
        {
            //TODO: Load default bookings to all bookings
            //TODO: Load room bookings
            //TODO: Assign member to booking
        }

        //Equipment bookings
        for( int i = 0; i < MAX; i++ )
        {
            //TODO: Load default bookings to all bookings
            //TODO: Load equipment bookings
            //TODO: Assign member to booking
        }
    }

    public BookingData()
    {
        loadData();
    }
}
