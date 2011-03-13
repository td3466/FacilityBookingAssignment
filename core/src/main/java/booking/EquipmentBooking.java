package booking;

import equipment.Equipment;

/**
 * @author chinfei.yap@mincom.com
 * @since 0.12
 */
public class EquipmentBooking extends AbstractBooking implements BookingFee
{
    static final int DEFAULT_HOURS = 24;

    private Equipment equipment;

    //Encapsulated as part of the BookingFee interface
    private boolean bookable;

    //Encapsulated as part of the BookingFee interface
    private float bookingFee;

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setEquipment( Equipment equipment )
    {
        this.equipment = equipment;
    }

    public EquipmentBooking( Equipment equipment )
    {
        this.equipment = equipment;
    }

    public EquipmentBooking( )
    {
        super.setDuration( DEFAULT_HOURS );
    }


    /**
     * Methods implemented as part of the BookingFee interface
     */
    public void setBookable( boolean bookable )
    {
        this.bookable = bookable;
    }

    public boolean getBookable()
    {
        return bookable;
    }

    public void setBookingFee( float fee )
    {
        bookingFee = fee;
    }

    public float getBookingFee()
    {
        return bookingFee;
    }
}
