package toberemoved.contact;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class Contact
{
    private String Id;

    private String contactNumber;

    private String description;

    private ContactType contactType;

    public String getId()
    {
        return Id;
    }

    public void setId( String id )
    {
        Id = id;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public void setContactNumber( String contactNumber )
    {
        this.contactNumber = contactNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public ContactType getContactType()
    {
        return contactType;
    }

    public void setContactType( ContactType contactType )
    {
        this.contactType = contactType;
    }
}
