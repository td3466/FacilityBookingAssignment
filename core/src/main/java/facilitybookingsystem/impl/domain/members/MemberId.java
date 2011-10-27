package facilitybookingsystem.impl.domain.members;

import java.util.regex.PatternSyntaxException;

/**
 * TODO: Documentation Rules surrounding Id - Length is 8 characters - Id can only be numeric - Id must start with a 1,
 * 2, or 9
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class MemberId
{
    private static final int ID_LENGTH = 8;

    private Exception lastException;

    /**
     * @return The exception thrown by the last call to {@code validateId}. Will be {@code null} if there were no
     *         Exception.
     */
    public Exception getLastException()
    {
        return lastException;
    }

    /**
     * Checks if a given string is in the correct format for an Member Id. The format is: <ul> <li>8 characters
     * long</li> <li>Numeric characters</li> <li>The first character must be a 1, 2, or 9</li> </ul>
     *
     * @param Id The {@code Id} to be validated.
     *
     * @return {@code true} when {@code Id} is in the correct format, otherwise {@code false}.
     *
     * @throws IllegalArgumentException Thrown when {@code Id} is {@code null} or the incorrect length.
     *                                  PatternSyntaxException Thrown when {@code Id} is in an incorrect format.
     */
    public boolean validateId( String Id )
        throws IllegalArgumentException
    {
        //Check valid length
        if( ( Id == null ) || ( Id.length() != ID_LENGTH ) )
        {
            lastException = new IllegalArgumentException( "[Id] must be " + ID_LENGTH + " characters long." );
            return false;
        }

        //Check valid first character
        if( !Id.matches( "[129][0-9]*" ) )
        {
            lastException = new PatternSyntaxException( "[Id] must only contain numeric characters and begin with a 1,2, or 9.", "[129][0-9]*", -1 );
            return false;
        }

        //Successfully validated
        lastException = null;
        return true;
    }
}
