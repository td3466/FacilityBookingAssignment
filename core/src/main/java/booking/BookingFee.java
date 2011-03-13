package booking;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public interface BookingFee
{
    public void setBookable( boolean bookable );

    public boolean getBookable();

    public void setBookingFee( float fee );

    public float getBookingFee();
}
