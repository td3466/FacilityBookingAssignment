package facilitybookingsystem.impl.domain.booking;

import java.util.Calendar;
import java.util.Date;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 *         <p/>
 *         26/2/2011 Changed timeend to be calculated and a getter only.
 */
public abstract class AbstractBooking
{
    private Date bookingDate;

    private Date timeStart;

    private Calendar calendar;
//    private Date timeEnd;

    private int duration;

    private boolean cancelled;

    //This is a read only property to help
    // with knowing hte bookings that have finished?
    private boolean completed;

    private AbstractBookingItem bookingItem;

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
        if( timeStart == null )
        {
            //Return null if no start time set
            return null;
        }
        else
        {
            //Calculate end time from start time and duration
            Calendar calendar = Calendar.getInstance();
            calendar.setTime( timeStart );
            calendar.add( Calendar.HOUR_OF_DAY, duration );
            return calendar.getTime();
        }
    }

//    public void setTimeEnd( Date timeEnd )
//    {
//        this.timeEnd = timeEnd;
//    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration( int duration )
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

    public AbstractBookingItem getBookingItem()
    {
        return bookingItem;
    }

    public void setBookingItem( AbstractBookingItem bookingItem )
    {
        this.bookingItem = bookingItem;
    }

    public boolean isCompleted()
    {
        return ( cancelled == true ) || ( ( this.getTimeEnd() != null ) && ( Calendar.getInstance().getTime().after( this.getTimeEnd() ) ) );
//        return ( cancelled == true ) || ( ( timeEnd != null ) && ( Calendar.getInstance().getTime().after( timeEnd ) ) );
    }
}
