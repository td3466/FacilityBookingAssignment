package facilitybookingsystem.impl.domain.equipment;

import facilitybookingsystem.impl.domain.members.MemberId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import toberemoved.booking.AbstractBookingItem;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@NamedQueries(
    {
        @NamedQuery( name = "equipment.findAll", query = "FROM Equipment " ),
        @NamedQuery( name = "equipment.findById", query = "FROM Equipment WHERE id = :id" ),
        @NamedQuery( name = "equipment.deleteAll", query = "DELETE FROM Equipment " ),
        @NamedQuery( name = "equipment.deleteById", query = "DELETE FROM Equipment WHERE id= :id" )
    } )
@Entity
@Table( name = "EQUIPMENT" )
public class Equipment extends EquipmentId
{
    @Id
    private String Id;

    private String name;

    private Date purchaseDate;

    /**
     * Constructor needed for JPA. Will not compile without it.
     */
    @Deprecated
    public Equipment()
    {
    }

    /**
     * Construct a new Equipment instance.
     *
     * @param id           The unique identifier for the equipment. This needs to be validated by the {@link
     *                     EquipmentId} class to make sure it is in the correct format.
     * @param name         The name of the equipment.
     * @param purchaseDate The date the equipment was purchased.
     */
    public Equipment( String id, String name, Date purchaseDate )
    {
        //id cannot be null
        if( ( id == null ) || ( id.isEmpty() ) )
        {
            throw new IllegalArgumentException( "[id] must not be [null] or [empty]." );
        }

        //Validate the id
        if( !validateId( id ) )
        {
            throw new IllegalArgumentException( getLastException() );
        }

        this.Id = id;
        this.name = name;
        this.purchaseDate = purchaseDate;
    }

    /**
     * @return The unique identifier for the equipment
     */
    public String getId()
    {
        return Id;
    }

    /**
     * @return The name of the equipment.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The date the equipment was purchased.
     */
    public Date getPurchaseDate()
    {
        return purchaseDate;
    }
}
