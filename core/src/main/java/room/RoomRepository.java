package room;

import Data.RoomData;
import java.util.ArrayList;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class RoomRepository
{
    //    @Inject
    RoomData roomData = new RoomData();

    //Get all rooms
    public ArrayList<Room> getAllRooms()
    {
        return roomData.getRooms();
    }

    //Find a room given the Id
    public Room findRoomId( String Id )
    {
        Room room = null;

        //Loop through rooms and exit when Id matches
        for( Room r : getAllRooms() )
        {
            if( r.getId().equals( Id ) )
            {
                room = r;
                break;
            }
        }

        return room;
    }

    //TODO: Find rooms by capacity

    //TODO: Find rooms by type
}
