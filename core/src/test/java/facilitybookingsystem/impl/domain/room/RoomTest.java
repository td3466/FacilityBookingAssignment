package facilitybookingsystem.impl.domain.room;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * @author troy.dodson@mincom.com
 * @since 0.1
 */
public class RoomTest
{
    @Test
    public void testConstructor() throws Exception
    {
        // Test parameterless constructor
        {
            Room room = new Room();
        }

        // Test invalid arguments
        {
            Object[][] invalidArguments = {
                { null, RoomType.CLASS_ROOM, 1 },
                { "", RoomType.CLASS_ROOM, 1 },
                { "0", RoomType.CLASS_ROOM, -1 },
                { "0", RoomType.CLASS_ROOM, 0 }
            };

            for( Object[] arg : invalidArguments )
            {
                try
                {
                    String id = (String) arg[ 0 ];
                    RoomType type = (RoomType) arg[ 1 ];
                    int capacity = (Integer) arg[ 2 ];

                    Room room = new Room( id, type, capacity );
                }
                catch( IllegalArgumentException e )
                {
                    // Expected
                }
                catch( Exception e )
                {
                    fail();
                }
            }
        }

        // Test valid arguments
        {
            Room room = new Room( "1", RoomType.CLASS_ROOM, 1 );
            assertNotNull( room );
            assertEquals( "1", room.getId() );
            assertEquals( RoomType.CLASS_ROOM, room.getRoomType() );
            assertEquals( 1, room.getCapacity() );
        }
    }
}
