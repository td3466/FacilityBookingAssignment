package booking;

import equipment.Equipment;
import java.util.ArrayList;
import javax.inject.Inject;
import members.AbstractMemberEntity;
import room.Room;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class BookingRepository
{
//    @Inject
//    BookingData bookingData = new BookingData();

    //All booked rooms
    public ArrayList<Room> allBookedRooms()
    {
        return null;
    }

    //All booked equipment
    public ArrayList<Equipment> allBookedEquipment()
    {
        return null;
    }

    //All member bookings
    public ArrayList<Booking> allMemberBookings( AbstractMemberEntity member )
    {
        return null;
    }
}
