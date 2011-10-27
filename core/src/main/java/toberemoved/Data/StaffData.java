package toberemoved.Data;

import java.util.ArrayList;
import toberemoved.staff.Staff;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class StaffData
{
    private ArrayList<Staff> staffs = new ArrayList<Staff>();

    public ArrayList<Staff> getStaff()
    {
        return staffs;
    }

    public void removeAllStaff()
    {
        staffs.clear();
    }

    public void reloadStaff()
    {
        removeAllStaff();
        loadData();
    }

    private void loadData()
    {
        final String FIRST_NAME = "first";
        final String LAST_NAME = "last";
        final int MAX = 10;

        for( int i = 1; i <= MAX; i++ )
        {
            //TODO: Add staff id
            Staff staff = new Staff();
            staff.setFirstName( FIRST_NAME );
            staff.setLastName( LAST_NAME );

            staffs.add( staff );
        }
    }

    public StaffData()
    {
        loadData();
    }
}
