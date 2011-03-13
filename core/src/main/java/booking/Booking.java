package booking;

import members.AbstractMemberEntity;

/**
 * TODO: Documentation Assumption is that bookings are currently for members only
 *
 * @author edward.yakop@mincom.com
 *         <p/>
 *         26/2/2011 Removed bookableItems. It was better to associate a booking with the Room/Equipment, rather than
 *         the Room/equipment with the booking.
 *         <p/>
 *         13/3/2011 Note. This class has been created to distinguish between bookings for members, and in the future
 *         outside members.
 *         Added a property for a booking, to associate a member with a booking
 *
 * TODO: Apply member charges to the booking.
 */
public class Booking
{
    private AbstractMemberEntity bookingName;

    private AbstractBooking booking;

    public AbstractMemberEntity getBookingName()
    {
        return bookingName;
    }

    public void setBookingName( AbstractMemberEntity bookingName )
    {
        this.bookingName = bookingName;
    }

    public AbstractBooking getBooking()
    {
        return booking;
    }

    public void setBooking( AbstractBooking booking )
    {
        this.booking = booking;
    }

}
