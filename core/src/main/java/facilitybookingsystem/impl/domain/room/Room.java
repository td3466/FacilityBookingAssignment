package facilitybookingsystem.impl.domain.room;

import facilitybookingsystem.impl.domain.booking.AbstractBookingItem;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Class represents a Room at the Facility. Rooms can be booked. The default booking time is 2 hours.
 *
 * @author troy.dodson@mincom.com
 * @since 0.3
 */
@NamedQueries(
    {
        @NamedQuery( name = "room.findAll", query = "FROM Room " ),
        @NamedQuery( name = "room.findById", query = "FROM Room WHERE id = :id" ),
        @NamedQuery( name = "room.deleteAll", query = "DELETE FROM Room" ),
        @NamedQuery( name = "room.deleteById", query = "DELETE FROM Room  WHERE id= :id" )
    } )
@Entity
@Table( name = "ROOM" )
public class Room extends AbstractBookingItem
{
    static final float DEFAULT_DURATION = 2;

    @Id
    private String Id;

    private RoomType roomType;

    private int capacity;

    /**
     * Return the Id of the room. Id is used to uniquely identify the room.
     *
     * @return String The room's Id
     */
    public String getId()
    {
        return Id;
    }

    /**
     * Return the type of the room. See {@link RoomType} for a list of valid values
     *
     * @return {@code RoomType} The type of the room
     */
    public RoomType getRoomType()
    {
        return roomType;
    }

    /**
     * Returns the maximum capacity of the room.
     *
     * @return {@code int} The number of people room can hold
     */
    public int getCapacity()
    {
        return capacity;
    }

    public Room()
    {
        super.setDefaultDuration( DEFAULT_DURATION );
    }

    public Room( String Id, RoomType roomType, int capacity )
    {
        //TODO: Validate: Id cannot be null
        //TODO: Validate: capacity must be >= 0

        super.setDefaultDuration( DEFAULT_DURATION );
        this.Id = Id;
        this.roomType = roomType;
        this.capacity = capacity;
    }
}
