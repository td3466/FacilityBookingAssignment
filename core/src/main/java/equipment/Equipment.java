package equipment;

import booking.BookingFee;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class Equipment extends AbstractEquipmentEntity implements BookingFee
{
    //Encapsulated by BookingFee interface
    private boolean bookable;

    //Encapsulated by BookingFee interface
    private float bookingFee;


    /*
     * Members implemented as part of BookingFee interface
     */
    public void setBookable( boolean bookable )
    {
        //To change body of implemented methods use File | Settings | File Templates.
        this.bookable = bookable;
    }

    public boolean getBookable()
    {
        return bookable;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setBookingFee( float fee )
    {
        //To change body of implemented methods use File | Settings | File Templates.
        bookingFee = fee;
    }

    public float getBookingFee()
    {
        return bookingFee;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
