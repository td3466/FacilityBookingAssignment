package booking;

import Data.BookingData;
import equipment.AbstractEquipmentEntity;
import equipment.Equipment;
import java.util.ArrayList;
import java.util.Date;
import members.AbstractMemberEntity;
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
        for( RoomBooking b : bookingData.getRoomBookings() )
        {
            bookedRooms.add( b.getRoom() );
        }

        return bookedRooms;
    }

    //A particular Room's bookings
    public ArrayList<RoomBooking> roomBookings( Room room )
    {
        ArrayList<RoomBooking> roomBookings = new ArrayList<RoomBooking>();

        //Room cannot be null, so return empty arraylist
        if( room == null )
        {
            return roomBookings;
        }

        //Loop through all room bookings and find ones for the room passed in
        for( RoomBooking b : bookingData.getRoomBookings() )
        {
            if( b.getRoom().getId() == room.getId() )
            {
                roomBookings.add( b );
            }
        }

        return roomBookings;
    }

    //Find if a particular Room is booked given a date range
    public ArrayList<RoomBooking> roomBookingsByDate( Room room, Date startDate, Date endDate )
    {
        Exception validation = null;

        //Dates must not be null, and start date must be before end date
        validation = validateDates( startDate, endDate );
        if( validation != null )
        {
            //throw validation;
            return null;
        }

        ArrayList<RoomBooking> roomBookingsByDate = new ArrayList<RoomBooking>();

        //Room cannot be null, so return empty arraylist
        if( room == null )
        {
            return roomBookingsByDate;
        }

        //Loop through all room bookings and find ones for the room in the date range
        for( RoomBooking b : bookingData.getRoomBookings() )
        {
            if( ( b.getRoom().getId() == room.getId() ) && ( b.getTimeStart().getTime() >= startDate.getTime() ) && ( b.getTimeEnd().getTime() <= endDate.getTime() ) )
            {
                roomBookingsByDate.add( b );
            }
        }

        return roomBookingsByDate;
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
        for( EquipmentBooking b : bookingData.getEquipmentBookings() )
        {
            bookedEquipment.add( b.getEquipment() );
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
    public ArrayList<EquipmentBooking> equipmentBookings( AbstractEquipmentEntity equipment )
    {
        ArrayList<EquipmentBooking> equipmentBookings = new ArrayList<EquipmentBooking>();

        //Room cannot be null, so return empty arraylist
        if( equipment == null )
        {
            return equipmentBookings;
        }

        //Loop through all room bookings and find ones for the room passed in
        for( EquipmentBooking b : bookingData.getEquipmentBookings() )
        {
            if( b.getEquipment().getId() == equipment.getId() )
            {
                equipmentBookings.add( b );
            }
        }

        return equipmentBookings;
    }

    //Find if a particular Equipment is booked given a date range
    public ArrayList<EquipmentBooking> equipmentBookingsByDate( AbstractEquipmentEntity equipment, Date startDate, Date endDate )
    {
        Exception validation = null;

        //Dates must not be null, and start date must be before end date
        validation = validateDates( startDate, endDate );
        if( validation != null )
        {
            //throw validation;
            return null;
        }

        ArrayList<EquipmentBooking> equipmentBookingsByDate = new ArrayList<EquipmentBooking>();

        //Room cannot be null, so return empty arraylist
        if( equipment == null )
        {
            return equipmentBookingsByDate;
        }

        //Loop through all room bookings and find ones for the room in the date range
        for( EquipmentBooking b : bookingData.getEquipmentBookings() )
        {
            if( ( b.getEquipment().getId() == equipment.getId() ) && ( b.getTimeStart().getTime() >= startDate.getTime() ) && ( b.getTimeEnd().getTime() <= endDate.getTime() ) )
            {
                equipmentBookingsByDate.add( b );
            }
        }

        return equipmentBookingsByDate;
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
        for( Booking b : bookingData.getMemberBookings() )
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
    public float getBookingCharge( AbstractBooking booking )
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
        if( booking instanceof BookingFee )
        {
            totalCharge = ( (BookingFee) booking ).getBookingFee();
        }

        return totalCharge;
    }

    /**
     * Validate that dates are not null, and that a start date does not come after an ending date.
     *
     * @param startDate: The first date in a date range
     * @param endDate:   The last date in a date range
     *
     * @return {@code NullPointerException} if one of the dates are {@code null}. {@code Exception} if the start date
     *         and time is a later date than the start date and time. {@code Null} if valid.
     */
    private Exception validateDates( Date startDate, Date endDate )
    {
        //Must have a start and end time
        if( ( startDate == null ) || ( endDate == null ) )
        {
            return new NullPointerException( "Arguments [startDate] and [endDate] must not be null." );
        }

        //End time must not be before start time
        if( endDate.before( startDate ) )
        {
            return new Exception( "[startDate] must not be before [endDate]." );
        }

        //Return null if validation successful
        return null;
    }

    /**
     * Check booking exists in the repository.
     *
     * @param booking: The booking to find in the repository.
     *
     * @return {@code null} if booking exists in repository. {@code NullPointerException} when booking is null. {@code
     *         Exception} when booking doesn't exist.
     */
    private Exception validBooking( AbstractBooking booking )
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
