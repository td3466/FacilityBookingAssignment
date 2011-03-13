package booking;

import java.util.ArrayList;
import members.AbstractMemberEntity;
import members.staff.Staff;
import members.student.Student;

/**
 * TODO: Documentation Assumption is that bookings are currently for members only
 *
 * @author edward.yakop@mincom.com
 *         <p/>
 *         26/2/2011 Removed bookableItems. It was better to associate a booking with the Room/Equipment, rather than
 *         the Room/equipment with the booking.
 */
public abstract class Booking extends AbstractBooking
{
    private AbstractMemberEntity bookingName;

    private float fee;

    public AbstractMemberEntity getBookingName()
    {
        return bookingName;
    }

    public void setBookingName( AbstractMemberEntity bookingName )
    {
        this.bookingName = bookingName;
    }
}
