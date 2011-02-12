package members.staff;

import Data.StaffData;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class StaffRepository
{
//    @Inject
    StaffData staffData = new StaffData();

    //Get all staff
    public ArrayList<Staff> getAllStaff()
    {
        return staffData.getStaff();
    }

    //Find s staff given the id
    public Staff findStaffId(String Id)
    {
        Staff staff = null;

        //Loop through rooms and exit when Id matches
        for( Staff  s : getAllStaff() )
        {
            if( s.getId().equals( Id ) )
            {
                staff = s;
                break;
            }
        }

        return staff;
    }
}
