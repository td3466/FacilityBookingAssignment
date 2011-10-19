package facilitybookingsystem.impl.domain.Data;

import facilitybookingsystem.impl.domain.room.Room;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import static facilitybookingsystem.impl.domain.room.RoomType.CLASS_ROOM;
import static facilitybookingsystem.impl.domain.room.RoomType.COMPUTER_LABORATORY;
import static facilitybookingsystem.impl.domain.room.RoomType.LECTURE_THEATRE;

/**
 * Class to load Rooms for database.
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
//@Named
public class RoomData
{
    @PersistenceContext
    EntityManager em;

    @Transactional
    public List<Room> getRooms()
    {
        return em.createNamedQuery( "room.findAll", Room.class ).getResultList();
    }

    @Transactional
    public void removeAllRooms()
    {
        em.createNamedQuery( "room.deleteAll", Room.class ).executeUpdate();
    }

    @Transactional
    public void reloadRooms()
    {
        removeAllRooms();
        loadData();
    }

    @PostConstruct
    @Transactional void loadData()
    {
        final int MAX = 30;

        Room room1 = new Room( "1", CLASS_ROOM, 50 );
        em.persist( room1 );

        Random random = new Random( 500 );

        for( int i = 1; i <= MAX; i++ )
        {
            //Add 10 class rooms
            for( int j = 1; j <= 10; j++ )
            {
                Room room = new Room( Integer.toString( i ), CLASS_ROOM, random.nextInt() );

                em.persist( room );
            }

            //Add 10 Lecture theatres
            for( int j = 1; j <= 10; j++ )
            {
                Room room = new Room( Integer.toString( i ), LECTURE_THEATRE, random.nextInt() );

                em.persist( room );
            }

            //Add 10 computer labs
            for( int j = 1; j <= 10; j++ )
            {
                Room room = new Room( Integer.toString( i ), COMPUTER_LABORATORY, random.nextInt() );

                em.persist( room );
            }
        }
    }
}
