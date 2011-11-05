package facilitybookingsystem.impl.domain.room;

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Named
public class RoomRepository
{
    @PersistenceContext
    EntityManager entityManager;

    //Get all rooms
    @Transactional
    public List<Room> getAllRooms()
    {
        return entityManager.createNamedQuery( "room.findAll", Room.class )
            .getResultList();
    }

    //Find a room given the Id
    @Transactional
    public Room findRoomId( String id )
    {
        return entityManager.createNamedQuery( "room.findById", Room.class )
            .setParameter( "id", id )
            .getSingleResult();
    }

    //TODO: Find available rooms by capacity

    //TODO: Find available rooms by type

    // TODO: Find available rooms
}
