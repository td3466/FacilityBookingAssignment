package Data;

import equipment.Equipment;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class EquipmentData
{
    private ArrayList<Equipment> equipments = new ArrayList<Equipment>();

    public ArrayList<Equipment> getEquipments()
    {
        return equipments;
    }

    public void removeAllEquipment()
    {
        equipments.clear();
    }

    public void reloadEquipment()
    {
        removeAllEquipment();
        loadData();
    }
    
    private void loadData()
    {
        final String NAME = "Equipment";
        final String DESCRIPTION = "Description";
        final int MAX = 30;

        for( int i = 1; i <= MAX; i++ )
        {
            //TODO: Add equipment ID
            Equipment equipment = new Equipment();
            equipment.setName( NAME + Integer.toString( i ) );
            equipment.setPurchaseDate( Calendar.getInstance().getTime() );
            equipment.setDescription( DESCRIPTION + Integer.toString( i ) );

            equipments.add( equipment );
        }
    }

    public EquipmentData()
    {
        loadData();
    }
}
