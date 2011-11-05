package facilitybookingsystem.impl.domain.booking;

import java.util.Date;
import org.junit.Test;

/**
 * @author troy.dodson@mincom.com
 * @since 0.1
 */
public class BookingTest
{
    @Test
    public void testConstructor() throws Exception
    {
        // Test parameterless constructor
        {
            Booking booking = new Booking();
        }

        // Test invalid arguments
        {
            Object[][] invalidArguments = {
                { null, null, 0 },
                { new Date(), null, 0 },
                { new Date(), new Date(), 0 },
                { new Date(), new Date(), -1 }
            };
        }
    }
}
