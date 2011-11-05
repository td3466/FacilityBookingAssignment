package facilitybookingsystem.impl.domain.members;

/**
 * TODO: Documentation Assumption is that, even though it is a list for future expansion, members will only have 1
 * contact at the moment.
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public abstract class AbstractMember extends MemberId
{
    private String Id;
    private String firstName;
    private String lastName;
    private String address;

    /**
     * @return The unique identifier of the member.
     */
    public String getId()
    {
        return Id;
    }

    /**
     * @param id The value of the unique identifier for the member. Must abide by the rules of the {@link MemberId}
     *           class.
     *
     * @throws IllegalArgumentException when {@code id} does not comply with the rules of {@code MemberId}.
     */
    public void setId( String id )
        throws IllegalArgumentException
    {
        if( !validateId( id ) )
        {
            throw new IllegalArgumentException( getLastException() );
        }

        this.Id = id;
    }

    /**
     * @return the First name as a {@code String}.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName The first name of the member. Can be {@code null}.
     */
    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    /**
     * @return The last name as a {@code String}.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName The last name of the member. Can be {@code null}.
     */
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    /**
     * @return The address of the member as a {@code String}.
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address The address of the member. Can be {@code null}.
     */
    public void setAddress( String address )
    {
        this.address = address;
    }
}
