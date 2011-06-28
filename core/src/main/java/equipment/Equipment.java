package equipment;

import booking.AbstractBookingItem;
import equipment.equipmentid.EquipmentIdEntity;
import java.util.Date;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class Equipment extends AbstractBookingItem
{
    static final float DEFAULT_DURATION = 24;

    private EquipmentIdEntity Id;

    private String name;

    private Date purchaseDate;

    private String description;

    public String getId()
    {
        return Id.getId();
    }

    public void setId( String id )
    {
        Id.setId( id );
    }

    public EquipmentIdEntity getIdGenerator() throws CloneNotSupportedException
    {
        //Return a copy of the class
        // to prevent people messing with original.
        //This is not as efficient, but a good experience
        //understanding implementing the Cloneable interface.
        return Id.clone();
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Date getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate( Date purchaseDate )
    {
        this.purchaseDate = purchaseDate;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public Equipment()
    {
        super.setDefaultDuration( DEFAULT_DURATION );
        Id = new EquipmentIdEntity();
    }
}
