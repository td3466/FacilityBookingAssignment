package Data;

import java.util.ArrayList;
import java.util.Random;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import room.Room;

import static room.RoomType.CLASS_ROOM;
import static room.RoomType.COMPUTER_LABORATORY;
import static room.RoomType.LECTURE_THEATRE;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class RoomData
{
    @PersistenceContext
    EntityManager em;

    private ArrayList<Room> rooms = new ArrayList<Room>();

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    public void removeAllRooms()
    {
        rooms.clear();
    }

    public void reloadRooms()
    {
        removeAllRooms();
        loadData();
    }

    private void loadData()
    {
        final int MAX=30;

        Random random = new Random( 500 );

        for( int i = 1; i <= MAX; i++ )
        {
            //Add 10 class rooms
            for( int j = 1; j <= 10; j++ )
            {
                Room room = new Room();
                room.setId( Integer.toString( i ) );
                room.setRoomType( CLASS_ROOM );
                room.setCapacity( random.nextInt() );

                em.persist( room );
                rooms.add( room );
            }

            //Add 10 Lecture theatres
            for( int j = 1; j <= 10; j++ )
            {
                Room room = new Room();
                room.setId( Integer.toString( i ) );
                room.setRoomType( LECTURE_THEATRE );
                room.setCapacity( random.nextInt() );

                em.persist( room );
                rooms.add( room );
            }

            //Add 10 computer labs
            for( int j = 1; j <= 10; j++ )
            {
                Room room = new Room();
                room.setId( Integer.toString( i ) );
                room.setRoomType( COMPUTER_LABORATORY );
                room.setCapacity( random.nextInt() );

                em.persist( room );
                rooms.add( room );
            }
        }
    }

    public RoomData()
    {
        loadData();
    }
}
