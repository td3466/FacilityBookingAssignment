package booking;

import Data.BookingData;
import equipment.AbstractEquipmentEntity;
import equipment.Equipment;
import java.util.ArrayList;
import java.util.Date;
import members.AbstractMemberEntity;
import members.student.Student;
import room.Room;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class BookingRepository
{
    //    @Inject
    BookingData bookingData = new BookingData();

    /**
     * All rooms associated with an active booking. Assumes currently that a booking can only be for 1 item.
     *
     * @return ArrayList of all the booked rooms
     */
    public ArrayList<Room> allBookedRooms()
    {
        ArrayList<Room> bookedRooms = new ArrayList<Room>();

        //Loop through all bookings and add the room from bookings of type RoomBooking
        //to the return ArrayList
        for( Booking b : bookingData.getBookings() )
        {
            if( b instanceof RoomBooking )
            {
                bookedRooms.add( ( (RoomBooking) b ).getRoom() );
            }
        }

        return bookedRooms;
    }

    //A particular Room's bookings
    public ArrayList<Room> roomBookings( Room room )
    {
        return null;
    }

    //Find if a particular Room is booked given a date range
    public ArrayList<Booking> roomBookingsByDate( Room room, Date startDate, Date endDate )
    {
        return null;
    }

    /**
     * All equipment associated with an active booking. Assumes currently that a booking can only be for 1 item.
     *
     * @return ArrayList of all booked equipment
     */
    public ArrayList<Equipment> allBookedEquipment()
    {
        ArrayList<Equipment> bookedEquipment = new ArrayList<Equipment>();

        //Loop through all bookings and add the equipment from bookings of type EquipmentBooking
        //to the return ArrayList
        for( Booking b : bookingData.getBookings() )
        {
            if( b instanceof EquipmentBooking )
            {
                bookedEquipment.add( ( (EquipmentBooking) b ).getEquipment() );
            }
        }

        return bookedEquipment;
    }

    /**
     * All bookings for a particular equipment.
     *
     * @param equipment The equipment to find the bookings for. Must not be [null].
     *
     * @return ArrayList of the equipment's bookings.
     */
    public ArrayList<Booking> equipmentBookings( AbstractEquipmentEntity equipment )
    {
        return null;
    }

    //Find if a particular Equipment is booked given a date range
    public ArrayList<Booking> equipmentBookingsByDate( AbstractEquipmentEntity equipment, Date startDate, Date endDate )
    {
        return null;
    }

    /**
     * All bookings for a particular member.
     *
     * @param member The member to find the bookings for. Must not be [null].
     *
     * @return ArrayList of the member's bookings
     */
    public ArrayList<Booking> allMemberBookings( AbstractMemberEntity member )
    {
        //Fail if no valid member
        if( member == null )
        {
//            throw new InvalidArgumentException("Argument [member] not set.");
            return null;
        }

        ArrayList<Booking> bookings = new ArrayList<Booking>();

        //Loop through all bookings and add bookings for the member passed in
        //to the return ArrayList
        for( Booking b : bookingData.getBookings() )
        {
            if( ( b.getBookingName() != null ) && ( b.getBookingName().getId() == member.getId() ) )
            {
                bookings.add( b );
            }
        }

        return bookings;
    }

    /**
     * Get booking charge - Charge for members should override charge for items
     *
     * @param
     *
     * @return
     */
    public float getBookingCharge( Booking booking )
    {
        Exception validation = null;

        //booking must not be null
        validation = validBooking( booking );
        if( validation != null )
        {
//            throw validation;
            return 0;
        }

        //Calculate charge from booking items
        //Assume for the moment bookings only available to Staff and Students
        float totalCharge = 0;
        if( booking.getBookingName() instanceof Student )
        {
            if( ( booking instanceof RoomBooking ) && ( ( (RoomBooking) booking ).getRoom() instanceof BookingFee ) )
            {
            }
            else if( ( booking instanceof EquipmentBooking ) &&
                     ( ( (EquipmentBooking) booking ).getEquipment() instanceof BookingFee ) )
            {
            }
        }

        return totalCharge;
    }

    /**
     * Check booking exists in the repository.
     *
     * @param booking: The booking to find in the repository.
     *
     * @return {@code null} if booking exists in repository. {@code NullPointerException} when booking is null. {@code
     *         Exception} when booking doesn't exist.
     */
    private Exception validBooking( Booking booking )
    {
        //Booking must not be null
        if( booking == null )
        {
            return new NullPointerException( "Argument [booking] must not be null." );
        }

//        //Booking must exist in the repository
//        if (bookingRepository.findBooking() == null)
//        {
//            return new Exception( "Booking [booking] does not exist in the repository." );
//        }

        //Return null if booking exists.
        return null;
    }
}
