package facilitybookingsystem.impl.domain.booking;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author troy.dodson@mincom.com
 * @since 0.1
 */
@Entity
@Table( name = "BOOKING" )
public class Booking
{
    @Id
    String id;

    Date date;
    Date time;
    float duration;

    /**
     * Needed for JPA.
     */
    @Deprecated
    public Booking()
    {
    }

    /**
     * Construct a new instance of a booking class.
     *
     * @param date     The date of a booking. Must not be {@code null}.
     * @param time     The time of the booking. Must not be {@code null}.
     * @param duration How long the booking is for. Must be a value greater than 0. Duration is in hours
     */
    public Booking( Date date, Date time, float duration )
    {
        // date should not be null
        if( date == null )
        {
            throw new IllegalArgumentException( "[date] must not be [null]." );
        }

        // time should not be null
        if( time == null )
        {
            throw new IllegalArgumentException( "[time] must not be [null]." );
        }

        // duration should be > 0
        if( duration <= 0 )
        {
            throw new IllegalArgumentException( "[duration] must be greater than [0]." );
        }

        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    /**
     * @return Unique identifier for the booking. Required for JPA.
     */
    public String getId()
    {
        return id;
    }

    /**
     * @return The date of the booking
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @return The time of the booking.
     */
    public Date getTime()
    {
        return time;
    }

    /**
     * @return a floating point value representing the duration of the booking. Duration is measured in hours. Will be
     *         greater than 0
     */
    public float getDuration()
    {
        return duration;
    }

    /**
     * @return The end time calculated from the date, time and duration.
     */
    public Date endTime()
    {
        Calendar calDate = Calendar.getInstance();
        calDate.setTime( date );
        Calendar calTime = Calendar.getInstance();
        calTime.setTime( time );

        // Combine date and time to a single Date object
        calDate.set( Calendar.HOUR_OF_DAY, calTime.get( Calendar.HOUR_OF_DAY ) );
        calDate.set( Calendar.MINUTE, calTime.get( Calendar.MINUTE ) );

        // Get duration in minutes
        int minutes = ( (Float) ( duration * 60 ) ).intValue();

        // Add the duration to the date
        calDate.add( Calendar.MINUTE, minutes );

        return calDate.getTime();
    }
}
