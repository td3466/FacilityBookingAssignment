package facilitybookingsystem.impl.domain.equipment;

import facilitybookingsystem.impl.domain.Data.EquipmentData;
import java.util.ArrayList;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class EquipmentRepository
{
    //    @Inject
    EquipmentData equipmentData = new EquipmentData();

    //Get all equipment
    public ArrayList<Equipment> getAllEquipment()
    {
        return equipmentData.getEquipments();
    }

    //Find a piece of equipment given the id
    public Equipment findEquipmentId( String Id )
    {
        Equipment equipment = null;

        //Loop through equipment and exit when Id matches
        for( Equipment e : getAllEquipment() )
        {
            if( e.getId().equals( Id ) )
            {
                equipment = e;
                break;
            }
        }

        return equipment;
    }
}
