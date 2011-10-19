package facilitybookingsystem.impl.domain.equipment.equipmentid;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class EquipmentIdEntity
    implements Cloneable
{
    private static final int ID_LENGTH = 10;

    private String Id;

    private Exception IdError;

    public String getId()
    {
        return Id;
    }

    public void setId( String id )
    {
        try
        {
            //Validate Id
            IdError = null;
            IdError = validateId( id );
        }
        catch( Exception e )
        {
            //Set IdError to error that occurred performing validation
            IdError = e;
        }
        finally
        {
            //Set to null if an error in validation
            if( IdError != null )
            {
                id = null;
            }

            //Set value of id
            Id = id;
        }
    }

    public Exception getIdError()
    {
        return IdError;
    }

    /**
     * Implementation of the Cloneable interface
     *
     * @return EquipmentIdEntity object that is a copy of the internal variable Id
     *
     * @throws CloneNotSupportedException
     */
    public EquipmentIdEntity clone() throws CloneNotSupportedException
    {
        return new EquipmentIdEntity( this.Id );
    }

    private Exception validateId( String Id )
        throws Exception
    {
        //Check correct length
        if( Id.length() != ID_LENGTH )
        {
            return new Exception( "Equipment ID must be " + ID_LENGTH + " characters long." );
        }

        //Check correct format
        if( !Id.matches( "EQ[0-9]*" ) )
        {
            return new Exception( "Equipment ID must be in format EQ########." );
        }

        //Successful validation
        return null;
    }

    public EquipmentIdEntity()
    {
    }

    public EquipmentIdEntity( String Id )
    {
        this.setId( Id );
    }
}
