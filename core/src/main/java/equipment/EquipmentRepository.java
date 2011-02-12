package equipment;

import Data.EquipmentData;
import equipment.equipmentid.EquipmentIdEntity;
import java.util.ArrayList;
import javax.inject.Inject;

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
    public Equipment findEquipmentId(String Id)
    {
        Equipment equipment = null;

        //Loop through equipment and exit when Id matches
        for (Equipment e: getAllEquipment())
        {
            if (e.getId().equals( Id ))
            {
                equipment = e;
                break;
            }
        }

        return equipment;
    }
}
