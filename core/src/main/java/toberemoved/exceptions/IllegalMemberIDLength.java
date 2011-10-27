package toberemoved.exceptions;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Deprecated
public class IllegalMemberIDLength extends Exception
{
    private static final String MAX = "8";
    private static final String MSG = "Member ID must be " + MAX + " characters long.";

    String msg;

    public IllegalMemberIDLength()
    {
        msg = MSG;
    }
}
