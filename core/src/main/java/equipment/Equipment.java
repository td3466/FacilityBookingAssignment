package equipment;

import booking.BookableItem;
import booking.BookingFee;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class Equipment extends AbstractEquipmentEntity implements BookableItem, BookingFee
{
    //Encapsulated by BookableItem interface
    private boolean bookableItem;

    //Encapsulated by BookingFee interface
    private float bookingFee;

    /*
     * Members implemented as part of BookableItem interface
     */
    public void setBookable( boolean bookable )
    {
        //To change body of implemented methods use File | Settings | File Templates.
        bookableItem = bookable;
    }

    public boolean getBookable()
    {
        return bookableItem;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /*
     * Members implemented as part of BookingFee interface
     */
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
