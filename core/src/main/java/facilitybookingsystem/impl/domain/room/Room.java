package facilitybookingsystem.impl.domain.room;

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
public class Room
{
    @Id
    private String Id;

    private RoomType roomType;

    private int capacity;

    /**
     * Constructor needed for JPA. Will not compile without it.
     */
    @Deprecated
    public Room()
    {
    }

    /**
     * Construct a new room instance.
     *
     * @param id       The unique identifier of the room
     * @param roomType The room's type
     * @param capacity The number of people the room can hold.
     */
    public Room( String id, RoomType roomType, int capacity )
    {
        //id can not be null
        if( ( id == null ) || ( id.isEmpty() ) )
        {
            throw new IllegalArgumentException( "[id] must not be [null] or [empty]." );
        }

        //Capacity must be > 0
        if( capacity < 1 )
        {
            throw new IllegalArgumentException( "[capacity] must be [1] or more." );
        }

        this.Id = id;
        this.roomType = roomType;
        this.capacity = capacity;
    }

    /**
     * Return the id of the room. id is used to uniquely identify the room.
     *
     * @return String The room's id; must not return {@code null}.
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
     * @return {@code int} The number of people room can hold; must return a number greater than 0.
     */
    public int getCapacity()
    {
        return capacity;
    }
}
