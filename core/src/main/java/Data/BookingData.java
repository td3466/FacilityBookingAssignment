package Data;

import booking.AbstractBooking;
import booking.Booking;
import booking.EquipmentBooking;
import booking.RoomBooking;
import java.util.ArrayList;

/**
 * @author chinfei.yap@mincom.com
 * @since 0.12
 */
public class BookingData
{
    private ArrayList<AbstractBooking> bookings = new ArrayList<AbstractBooking>(  );

    private ArrayList<RoomBooking> roomBookings = new ArrayList<RoomBooking>(  );

    private ArrayList<EquipmentBooking> equipmentBookings = new ArrayList<EquipmentBooking>(  );

    private ArrayList<Booking> memberBookings = new ArrayList<Booking>(  );

    public ArrayList<AbstractBooking> getBookings()
    {
        return bookings;
    }

    public ArrayList<RoomBooking> getRoomBookings()
    {
        return roomBookings;
    }

    public ArrayList<EquipmentBooking> getEquipmentBookings()
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
        final int MAX=30;

        //Room bookings
        for (int i=0;i<MAX;i++)
        {
            //TODO: Load default bookings to all bookings
            //TODO: Load room bookings
            //TODO: Assign member to booking
        }

        //Equipment bookings
        for (int i=0;i<MAX;i++)
        {
            //TODO: Load default bookings to all bookings
            //TODO: Load equipment bookings
            //TODO: Assign member to booking
        }
    }

    public BookingData(  )
    {
        loadData();
    }
}
