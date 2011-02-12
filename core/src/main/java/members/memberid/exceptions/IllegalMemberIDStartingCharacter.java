package members.memberid.exceptions;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Deprecated
public class IllegalMemberIDStartingCharacter extends Exception
{
    private static final String MSG = "Member ID must start with 1,2, or 9.";

    private String msg;

    public IllegalMemberIDStartingCharacter()
    {
        msg = MSG;
    }
}
