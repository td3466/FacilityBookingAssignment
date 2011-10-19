package facilitybookingsystem.impl.domain.members.memberid;

/**
 * TODO: Documentation Rules surrounding Id - Length is 8 characters - Id can only be numeric - Id must start with a 1,
 * 2, or 9
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class MemberIdEntity
    implements Cloneable
{
    private static final int ID_LENGTH = 8;

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
            //Set IdError to any exception in validation
            IdError = e;
        }
        finally
        {
            //Set to null if an error in validation
            if( IdError != null )
            {
                id = null;
            }

            //Set value of Id
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
    public MemberIdEntity clone() throws CloneNotSupportedException
    {
        return new MemberIdEntity( this.Id );
    }

    /**
     * TODO: Doco
     *
     * @param Id
     *
     * @return
     *
     * @throws Exception
     */
    private Exception validateId( String Id )
        throws Exception
    {
        //Check valid length
        if( Id.length() != ID_LENGTH )
        {
            return new Exception( "Member ID must be " + ID_LENGTH + " characters long." );
            //return new IllegalMemberIDLength();
        }

//        //Check only numeric characters
//       if (!Id.matches( "[0-9]*" ))
//        {
//            //return new IllegalMemberIDCharacters();
//        }

        //Check valid first character
        if( !Id.matches( "[129][0-9]*" ) )
        {
            return new Exception( "Member ID must only contain numeric characters and begin with a 1,2, or 9." );
            //return new IllegalMemberIDStartingCharacter();
        }

        //Successfully validated
        return null;
    }

    public MemberIdEntity()
    {
    }

    public MemberIdEntity( String Id )
    {
        this.setId( Id );
    }
}
