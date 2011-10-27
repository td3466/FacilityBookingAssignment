package toberemoved.booking;

import toberemoved.Data.BookingData;
import toberemoved.equipment.Equipment;
import toberemoved.equipment.EquipmentRepository;
import java.util.Date;
import facilitybookingsystem.impl.domain.members.AbstractMemberEntity;
import toberemoved.staff.Staff;
import toberemoved.staff.StaffRepository;
import toberemoved.student.Student;
import toberemoved.student.StudentRepository;
import toberemoved.room.Room;
import toberemoved.room.RoomRepository;

/**
 * TODO: Documentation AKA BookingService. Assignment requirements required the BookingService class be called
 * BookingManagement
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class BookingManagement
{
    //    @Inject
    BookingData bookingData = new BookingData();

    //    @Inject
    RoomRepository roomRepository = new RoomRepository();

    //    @Inject
    EquipmentRepository equipmentRepository = new EquipmentRepository();

    //    @Inject
    StaffRepository staffRepository = new StaffRepository();

    //    @Inject
    StudentRepository studentRepository = new StudentRepository();

    //    @Inject
    BookingRepository bookingRepository = new BookingRepository();

    /**
     * Create a new booking - Booking shouldn't clash with existing bookings
     */
    public AbstractBooking createBooking( AbstractMemberEntity member, Date startDateTime, Date endDateTime, AbstractBookingItem bookingItem )
    {
        Exception validation = null;

        //Dates must be a valid range
        validation = validateDates( startDateTime, endDateTime );
        if( validation != null )
        {
//            throw validation;
            return null;
        }

        //If a member specified, must be a valid member
        validation = validMember( member );
        if( validation != null )
        {
//            throw validation;
            return null;
        }

        //BookingItem must be a valid booking item
        validation = validBookingItem( bookingItem );
        if( validation != null )
        {
//            throw validation;
            return null;
        }

        //Booking must not clash with other bookings
        validation = validateConflictingBookings( bookingItem, startDateTime, endDateTime );
        if( validation != null )
        {
//            throw validation;
            return null;
        }

        //Create the booking
        Booking booking = new Booking();
        booking.setBookingDate( startDateTime );
        booking.setTimeStart( startDateTime );
        booking.setBookingItem( bookingItem );
        booking.setBookingName( member );

        //Set charges depending on if staff or student
        if( member instanceof Student )
        {
            if( bookingItem instanceof Room )
            {
                bookingItem.setBookingFee( ( (Student) member ).getRoomFee() );
            }
            else if( bookingItem instanceof Equipment )
            {
                bookingItem.setBookingFee( ( (Student) member ).getEquipmentFee() );
            }
        }

        //Persist the booking

        return booking;
    }

    /**
     * Cancel a booking
     */
    public boolean cancelBooking( AbstractBooking booking )
    {
        //booking must not be null
        if( booking == null )
        {
//            throw new NullPointerException( "Argument [booking] must not be [null]." );
            return false;
        }

        //cannot cancel an already completed booking
        if( booking.isCompleted() )
        {
//            throw new Exception( "Can't cancel completed booking" );
            return false;
        }

        //Cancel booking all being good
        booking.setCancelled( true );

        //Persist the changes

        return true;
    }

    /**
     * Change booking date - New date shouldn't clash with existing bookings
     *
     * @param booking
     * @param newStartDateTime
     * @param newEndDateTime
     *
     * @return
     */
    public boolean changeBookingDate( AbstractBooking booking, Date newStartDateTime, Date newEndDateTime )
    {
        Exception validation = null;

        //Booking must be a valid booking
        validation = validBooking( booking );
        if( validation != null )
        {
//            throw validation;
            return false;
        }

        validation = validateDates( newStartDateTime, newEndDateTime );
        if( validation != null )
        {
//            throw validation;
            return false;
        }

        //Dates and times must not clash with other bookings
        validation = validateConflictingBookings( booking.getBookingItem(), booking.getTimeStart(), booking.getTimeEnd() );
        if( validation != null )
        {
//            throw validation;
            return false;
        }

        //All being good, change the dates
        booking.setTimeStart( newStartDateTime );
        //TODO: Set new duration

        //Persist the changes

        return false;
    }

    /**
     * Check that a bookingItem isn't already booked for the dat and time
     *
     * @return {@code NullPointerException} if one of the dates are {@code null}. {@code Exception} if the bookingItem
     *         is already booked. {@code null} if the bookingItem is not booked.
     */
    private Exception validateConflictingBookings( AbstractBookingItem bookingItem, Date startDateTime, Date endDateTime )
    {
        if( ( bookingItem instanceof Room ) && ( bookingRepository.roomBookingsByDate( (Room) bookingItem, startDateTime, endDateTime ).size() > 0 ) )
        {
            return new Exception( "Room [bookingItem.getId] already booked for that time." );
        }
        else if( ( bookingItem instanceof Equipment ) && ( bookingRepository.equipmentBookingsByDate( (Equipment) bookingItem, startDateTime, endDateTime ).size() > 0 ) )
        {
            return new Exception( "Equipment [bookingItem.getId] already booked for that time." );
        }

        return new Exception( "[bookingItem] is an unknown type of booking item." );
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
     * Check member is not null, and a valid member item.
     *
     * @param member: The bookable item to validate. This will be a {@link Room} or {@link Equipment}.
     *
     * @return {@code null} if valid, otherwise {@code Exception}.
     */
    private Exception validMember( AbstractMemberEntity member )
    {
        //BookableItem must not be null
        if( member == null )
        {
            return new NullPointerException( "Argument [member] must not be null." );
        }

        //Validate for type of bookable item
        if( member instanceof Staff )
        {
            return validStaffMember( (Staff) member );
        }
        else if( member instanceof Student )
        {
            return validStudent( (Student) member );
        }

        return null;
    }

    /**
     * Check a staff member exists in the repository
     *
     * @param member: The staff member to check for. This can be {@code null}
     *
     * @return {@code null} if the staff member exists, otherwise {@code Exception}
     */
    private Exception validStaffMember( Staff member )
    {
        //check member exists
        if( ( member != null ) && ( staffRepository.findStaffId( member.getId() ) == null ) )
        {
            return new Exception( "Staff member [member] does not exist." );
        }

        //Return null if valid member
        return null;
    }

    /**
     * Check a student exists in the repository
     *
     * @param member: The student to check for. This can be {@code null}
     *
     * @return {@code null} if the student exists, otherwise {@code Exception}
     */
    private Exception validStudent( Student member )
    {
        //Check member exists
        if( ( member != null ) && ( studentRepository.findStudentId( member.getId() ) == null ) )
        {
            return new Exception( "Student [member] does not exist." );
        }

        //Return null if valid member
        return null;
    }

    /**
     * Check bookable item is not null, and a valid bookable item.
     *
     * @param bookableItem: The bookable item to validate. This will be a {@link Room} or {@link Equipment}.
     *
     * @return {@code null} if valid, otherwise {@code Exception}.
     */
    private Exception validBookingItem( AbstractBookingItem bookableItem )
    {
        //BookableItem must not be null
        if( bookableItem == null )
        {
            return new NullPointerException( "Argument [bookableItem] must not be null." );
        }

        //Validate for type of bookable item
        if( bookableItem instanceof Equipment )
        {
            return validEquipment( (Equipment) bookableItem );
        }
        else if( bookableItem instanceof Room )
        {
            return validRoom( (Room) bookableItem );
        }

        return null;
    }

    /**
     * Check a piece of equipment exists in the repository.
     *
     * @param equipment: The piece of equipment to find. Must not be {@code null}.
     *
     * @return {@code null} if the equipment exists, otherwise {@code Exception}.
     */
    private Exception validEquipment( Equipment equipment )
    {
        //Equipment must not be null
        if( equipment == null )
        {
            return new NullPointerException( "Argument [equipment] must not be null." );
        }

        //Equipment must exist in the repository
        if( equipmentRepository.findEquipmentId( equipment.getId() ) == null )
        {
            return new Exception( "Equipment [equipment] does not exist." );
        }

        //Return null if room exists
        return null;
    }

    /**
     * Check a room exists in the repository.
     *
     * @param room: The room to find. Must not be {@code null}.
     *
     * @return {@code null} if the equipment exists, otherwise {@code Exception}.
     */
    private Exception validRoom( Room room )
    {
        //Room must not be null
        if( room == null )
        {
            return new NullPointerException( "Argument [room] must not be null." );
        }

        //Room must exist in the repository
        if( roomRepository.findRoomId( room.getId() ) == null )
        {
            return new Exception( "Room [room] does not exist." );
        }

        //Return null if room exists
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
