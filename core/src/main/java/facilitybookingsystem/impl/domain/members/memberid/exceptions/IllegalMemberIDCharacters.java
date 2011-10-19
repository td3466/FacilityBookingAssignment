package facilitybookingsystem.impl.domain.members.memberid.exceptions;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Deprecated
public class IllegalMemberIDCharacters extends Exception
{
    private static final String MSG = "Member ID can only contain numeric (0..9) characters.";

    String msg;

    public IllegalMemberIDCharacters()
    {
        msg = MSG;
    }
}
