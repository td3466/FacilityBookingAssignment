package booking;

/**
 * TODO: Documentation
 * Applied to entities that can be booked
 * ie: Equipment, rooms
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public interface BookableItem
{
    public void setBookable( boolean bookable );

    public boolean getBookable();
}
