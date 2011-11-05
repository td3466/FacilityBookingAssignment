package toberemoved.student;

import facilitybookingsystem.impl.domain.members.AbstractMember;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class Student extends AbstractMember
{
    private static final float ROOM_FEE = 2;

    private static final float EQUIPMENT_FEE = 5;

    private float roomFee;

    private float equipmentFee;

    public float getRoomFee()
    {
        return roomFee;
    }

    public void setRoomFee( float roomFee )
    {
        this.roomFee = roomFee;
    }

    public float getEquipmentFee()
    {
        return equipmentFee;
    }

    public void setEquipmentFee( float equipmentFee )
    {
        this.equipmentFee = equipmentFee;
    }

    public Student()
    {
        //Set default fees
        roomFee = ROOM_FEE;
        equipmentFee = EQUIPMENT_FEE;
    }

    public Student( float roomFee, float equipmentFee )
    {
        //Set fees
        this.roomFee = roomFee;
        this.equipmentFee = equipmentFee;
    }
}
