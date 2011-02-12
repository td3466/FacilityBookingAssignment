package booking;

import java.util.ArrayList;
import members.AbstractMemberEntity;

/**
 * TODO: Documentation
 * Assumption is that bookings are currently for members only
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class Booking extends AbstractBooking
{
    private AbstractMemberEntity bookingName;

    private ArrayList<BookableItem> bookableItems = new ArrayList<BookableItem>(  );


    public AbstractMemberEntity getBookingName()
    {
        return bookingName;
    }

    public void setBookingName( AbstractMemberEntity bookingName )
    {
        this.bookingName = bookingName;
    }

    public ArrayList<BookableItem> getBookableItems()
    {
        return bookableItems;
    }

    public void addBookingItem( BookableItem booking )
    {
        //TODO: Only add if a bookable item

        bookableItems.add( booking );
    }

    public void removeBookingItem( BookableItem booking )
    {
        //Remove if contained in list
        if( bookableItems.contains( booking ) )
        {
            bookableItems.remove( booking );
        }
    }
}
