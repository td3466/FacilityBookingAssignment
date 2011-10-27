package facilitybookingsystem.impl.domain.equipment;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import toberemoved.booking.AbstractBookingItem;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Entity
@Table( name = "EQUIPMENT" )
public class Equipment
{
    @Id
    private String Id;

    private String name;

    private Date purchaseDate;

    public Equipment()
    {
    }

    public String getId()
    {
        return Id;
    }

    public void setId( String id )
    {
        this.Id = id;
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
}
