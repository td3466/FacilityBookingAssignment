package Data.derby;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.Hibernate;

/**
 * @author chinfei.yap@mincom.com
 * @since 0.12
 */
public class DatabaseConnection
{
    private static String dbURL = "jdbc:derby:memory:Facility";
    private static String dbDriver = "org.apache.derby.jdbc.EmbeddedDriver";

    // jdbc Connection
    private static Connection conn = null;
//    private static Statement stmt = null;

    /**
     * @return
     *
     * @throws Exception
     */
    public Connection createConnection() throws Exception
    {
        //Create connection if not set
        if( conn == null )
        {
            try
            {
                Class.forName( dbDriver ).newInstance();
                createDatabase();
                conn = DriverManager.getConnection( dbURL );
            }
            catch( Exception e )
            {
                System.out.print( e.getMessage() );
            }
        }

        //Return the connection class
        return conn;
    }

    /**
     * @throws Exception
     */
    public void closeConnection() throws Exception
    {
        //Close connection if set
        if( conn != null )
        {
            try
            {
                //dropDatabase();
                shutdownDatabase();
                conn.close();
            }
            catch( Exception e )
            {
                System.out.print( e.getMessage() );
            }
        }
    }

    /**
     * @throws Exception
     */
    private void createDatabase() throws Exception
    {
        try
        {
            DriverManager.getConnection( dbURL + ";create=true" );
        }
        catch( SQLException e )
        {
            System.out.print( e.getMessage() );
        }
        catch( Exception e )
        {
            System.out.print( e.getMessage() );
        }
    }

    /**
     * @throws Exception
     */
    private void dropDatabase() throws Exception
    {
        try
        {
            DriverManager.getConnection( dbURL + ";drop=true" );
        }
        catch( SQLException e )
        {
            System.out.print( e.getMessage() );
        }
        catch( Exception e )
        {
            System.out.print( e.getMessage() );
        }
    }

    /**
     * @throws Exception
     */
    private void shutdownDatabase() throws Exception
    {
        try
        {
            DriverManager.getConnection( dbURL + ";shutdown=true" );
        }
        catch( SQLException e )
        {
            System.out.print( e.getMessage() );
        }
        catch( Exception e )
        {
            System.out.print( e.getMessage() );
        }
    }

    private void createTable( String tableName )
    {

    }

    private void createSchema()
    {

    }
}
