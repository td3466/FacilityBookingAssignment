package toberemoved.equipment;

import java.util.regex.PatternSyntaxException;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class EquipmentId
{
    private final int ID_LENGTH = 10;

    private Exception lastException = null;

    /**
     * @return The exception thrown by the last call to {@code validateId}. Will return {@code null} if there was no
     *         Exception.
     */
    public Exception getLastException()
    {
        return lastException;
    }

    /**
     * Checks if a given string is in the correct format for an Equipment Id. The format is: <ul> <li>8 characters
     * long</li> <li>Numeric characters (except for the first 2 characters)</li> <li>"EQ" must be the first 2
     * characters</li> </ul>
     *
     * @param Id The {@code Id} to be validated.
     *
     * @return {@code true} when {@code Id} is in the correct format, otherwise {@code false}.
     *
     * @throws IllegalArgumentException when {@code Id} is {@code null} or empty. PatternSyntaxException when {@code Id}
     *                                  does not match the pattern correctly.
     */
    public boolean validateId( String Id )
        throws IllegalArgumentException
    {
        // Check correct length
        if( ( Id == null ) || ( Id.length() != ID_LENGTH ) )
        {
            lastException = new IllegalArgumentException( "[Id] must be [" + ID_LENGTH + "] characters long." );
            return false;
        }

        //Check correct format
        if( !Id.matches( "EQ[0-9]*" ) )
        {
            lastException = new PatternSyntaxException( "[Id] must be in format [EQ########].", "EQ[0-9]*", -1 );
            return false;
        }

        //Successful validation\
        lastException = null;
        return true;
    }
}
