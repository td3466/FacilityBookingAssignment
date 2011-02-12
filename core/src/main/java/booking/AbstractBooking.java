package booking;

import java.util.Calendar;
import java.util.Date;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public abstract class AbstractBooking
{
    private Date bookingDate;

    private Date timeStart;

    private Date timeEnd;

    private float duration;

    private boolean cancelled;

    //This is a read only property to help
    // with knowing hte bookings that have finished?
    private boolean completed;


    public Date getBookingDate()
    {
        return bookingDate;
    }

    public void setBookingDate( Date bookingDate )
    {
        this.bookingDate = bookingDate;
    }

    public Date getTimeStart()
    {
        return timeStart;
    }

    public void setTimeStart( Date timeStart )
    {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd()
    {
        return timeEnd;
    }

    public void setTimeEnd( Date timeEnd )
    {
        this.timeEnd = timeEnd;
    }

    public float getDuration()
    {
        return duration;
    }

    public void setDuration( float duration )
    {
        this.duration = duration;
    }

    public boolean getCancelled()
    {
        return cancelled;
    }

    public void setCancelled( boolean cancelled )
    {
        this.cancelled = cancelled;
    }

    public boolean isCompleted()
    {
        return ( cancelled == true ) || ( ( timeEnd != null ) && ( Calendar.getInstance().getTime().after( timeEnd ) ) );
    }
}
