package facilitybookingsystem.impl.domain.booking;

/**
 * @author chinfei.yap@mincom.com
 * @since 0.12
 */
public abstract class AbstractBookingItem
{
    private boolean bookable;

    private float bookingFee;

    private float defaultDuration;

    public boolean isBookable()
    {
        return bookable;
    }

    public void setBookable( boolean bookable )
    {
        this.bookable = bookable;
    }

    public float getBookingFee()
    {
        return bookingFee;
    }

    public void setBookingFee( float bookingFee )
    {
        this.bookingFee = bookingFee;
    }

    public float getDefaultDuration()
    {
        return defaultDuration;
    }

    public void setDefaultDuration( float defaultDuration )
    {
        this.defaultDuration = defaultDuration;
    }
}
