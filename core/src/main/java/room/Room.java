package room;

import booking.BookableItem;
import booking.BookingFee;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class Room implements BookableItem, BookingFee
{
    private String Id;

    private RoomType roomType;

    private int capacity;

    //Encapsulated by BookableItem interface
    private boolean bookableItem;

    //Encapsulated by BookingFee interface
    private float bookingFee;

    public String getId()
    {
        return Id;
    }

    public void setId( String id )
    {
        Id = id;
    }

    public RoomType getRoomType()
    {
        return roomType;
    }

    public void setRoomType( RoomType roomType )
    {
        this.roomType = roomType;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity( int capacity )
    {
        this.capacity = capacity;
    }


    /*
     * Methods implemented as part of BookableItem interface
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
     * Methods implemented as part of BookingFee interface
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
