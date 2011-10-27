package facilitybookingsystem.impl.domain.members;

/**
 * TODO: Documentation Assumption is that, even though it is a list for future expansion, members will only have 1
 * contact at the moment.
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public abstract class AbstractMemberEntity
{
    private String Id;
    private String firstName;
    private String lastName;
    private String address;

    public String getId()
    {
        return Id;
    }

    public void setId( String id )
        throws IllegalArgumentException
    {
        MemberId validate = new MemberId();
        if( !validate.validateId( id ) )
        {
            throw new IllegalArgumentException( validate.getLastException() );
        }

        this.Id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }
}
