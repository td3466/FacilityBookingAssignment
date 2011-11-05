package facilitybookingsystem.impl.domain.members;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * @author troy.dodson@mincom.com
 * @since 0.1
 */
public class AbstractMemberEntityTest
{
    @Test
    public void testId() throws Exception
    {
        AbstractMemberStub member = new AbstractMemberStub();

        // Test default values
        assertNull( member.getId() );

        // Test invalid id
        try
        {
            member.setId( "invalid" );
            fail();
        }
        catch( IllegalArgumentException e )
        {
            // Expected
        }
        catch( Exception e )
        {
            fail();
        }

        // Test valid id
        member.setId( "10000000" );
        assertEquals( "10000000", member.getId() );
    }

    @Test
    public void testFirstName() throws Exception
    {
        AbstractMemberStub member = new AbstractMemberStub();

        // Test default values
        assertNull( member.getFirstName() );

        // Test getter and setter
        member.setFirstName( "name" );
        assertEquals( "name", member.getFirstName() );

        // Test null
        member.setFirstName( null );
        assertNull( member.getFirstName() );
    }

    @Test
    public void testLastName() throws Exception
    {
        AbstractMemberStub member = new AbstractMemberStub();

        // Test default values
        assertNull( member.getLastName() );

        // Test getter and setter
        member.setLastName( "name" );
        assertEquals( "name", member.getLastName() );

        // Test null
        member.setLastName( null );
        assertNull( member.getLastName() );
    }

    @Test
    public void testAddress() throws Exception
    {
        AbstractMemberStub member = new AbstractMemberStub();

        // Test default values
        assertNull( member.getAddress() );

        // Test getter and setter
        member.setAddress( "address" );
        assertEquals( "address", member.getAddress() );

        // Test null
        member.setAddress( null );
        assertNull( member.getAddress() );
    }

    @Test
    public void testConstructor() throws Exception
    {
        AbstractMember member = new AbstractMemberStub();
    }

    /**
     * Class used to test
     */
    private class AbstractMemberStub extends AbstractMember
    {
        // Do nothing
    }
}
