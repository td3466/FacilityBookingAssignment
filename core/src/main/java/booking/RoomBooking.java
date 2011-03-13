package booking;

import room.Room;

/**
 * @author chinfei.yap@mincom.com
 * @since 0.12
 */
public class RoomBooking extends AbstractBooking implements BookingFee
{
    static final int DEFAULT_HOURS = 2;

    private Room room;

    //Encapsulated as part of the BookingFee interface
    private boolean bookable;

    //Encapsulated as part of the BookingFee interface
    private float bookingFee;

    public Room getRoom()
    {
        return room;
    }

    public void setRoom( Room room )
    {
        this.room = room;
    }

    public RoomBooking( Room room )
    {
        this.room = room;
    }

    public RoomBooking(  )
    {
        super.setDuration( DEFAULT_HOURS );
    }


    /**
     * Methods implemented as part of the BookingFee interface
     */
    public void setBookable( boolean bookable )
    {
        this.bookable = bookable;
    }

    public boolean getBookable()
    {
        return bookable;
    }

    public void setBookingFee( float fee )
    {
        bookingFee = fee;
    }

    public float getBookingFee()
    {
        return bookingFee;
    }
}
