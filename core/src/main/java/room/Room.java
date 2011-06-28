package room;

import booking.AbstractBookingItem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Entity
public class Room extends AbstractBookingItem
{
    static final float DEFAULT_DURATION = 2;

    @Id
    private String Id;

    private RoomType roomType;

    private int capacity;

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

    public Room()
    {
        super.setDefaultDuration( DEFAULT_DURATION );
    }
}
