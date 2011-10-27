package toberemoved.contact;

/**
 * TODO: Documentation Depreciated as the requirement was to have a 1 line string address
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Deprecated
public class Address
{
    private String Id;

    private String address1;

    private String address2;

    private String address3;

    private String address4;

    private String city;

    private String state;

    private String postCode;

    private String country;

    public String getId()
    {
        return Id;
    }

    public void setId( String id )
    {
        Id = id;
    }

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1( String address1 )
    {
        this.address1 = address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2( String address2 )
    {
        this.address2 = address2;
    }

    public String getAddress3()
    {
        return address3;
    }

    public void setAddress3( String address3 )
    {
        this.address3 = address3;
    }

    public String getAddress4()
    {
        return address4;
    }

    public void setAddress4( String address4 )
    {
        this.address4 = address4;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState( String state )
    {
        this.state = state;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode( String postCode )
    {
        this.postCode = postCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry( String country )
    {
        this.country = country;
    }
}
