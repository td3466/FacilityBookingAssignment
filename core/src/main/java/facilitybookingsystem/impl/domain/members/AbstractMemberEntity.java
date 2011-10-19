package facilitybookingsystem.impl.domain.members;

import java.util.ArrayList;
import facilitybookingsystem.impl.domain.members.contact.Contact;
import facilitybookingsystem.impl.domain.members.memberid.MemberIdEntity;

/**
 * TODO: Documentation Assumption is that, even though it is a list for future expansion, members will only have 1
 * contact at the moment.
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public abstract class AbstractMemberEntity
{
    private MemberIdEntity Id;

    private String firstName;

    private String lastName;

    private String address;

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public String getId()
    {
        return Id.getId();
    }

    public void setId( String id )
    {
        Id.setId( id );
    }

    public MemberIdEntity getIdGenerator() throws CloneNotSupportedException
    {
        //Return a copy of the class
        // to prevent people messing with original.
        //This is not as efficient, but a good experience
        //understanding implementing the Cloneable interface.
        return Id.clone();
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

    public ArrayList<Contact> getContacts()
    {
        return contacts;
    }

    public void addContact( Contact contact )
    {
        //Only allow 1 contact currently?
        if( contacts.size() > 0 )
        {
            throw new IndexOutOfBoundsException( "Max size is 1" );
        }

        contacts.add( contact );
    }

    public void removeContact( int index )
    {
        if( ( index > 0 ) && ( index < contacts.size() ) )
        {
            contacts.remove( index );
        }
    }
}
