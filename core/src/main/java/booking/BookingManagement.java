package booking;

import java.util.Date;
import members.AbstractMemberEntity;

/**
 * TODO: Documentation AKA BookingService. Assignment requirements required the BookingService class be called
 * BookingManagement
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class BookingManagement
{
    //Create a new booking
    // - Booking shouldn't clash with existing bookings
    public Booking createBooking( AbstractMemberEntity member, Date startDateTime, Date endDateTime )
    {
        return null;
    }

    //Cancel a booking
    public boolean cancelBooking( Booking booking )
    {
        return false;
    }

    //Change booking date
    // - New date shouldn't clash with existing bookings
    public boolean changeBookingDate( Booking booking, Date newStartDateTime, Date newEndDateTime )
    {
        return false;
    }

    //Get booking charge
    // - Charge for members should override charge for items
    public float getBookingCharge( Booking booking )
    {
        return 0;
    }
}
