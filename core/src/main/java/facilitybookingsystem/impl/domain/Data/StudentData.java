package facilitybookingsystem.impl.domain.Data;

import java.util.ArrayList;
import facilitybookingsystem.impl.domain.members.student.Student;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class StudentData
{
    private ArrayList<Student> students = new ArrayList<Student>();

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public void removeAllStudents()
    {
        students.clear();
    }

    public void reloadStudents()
    {
        removeAllStudents();
        loadData();
    }

    private void loadData()
    {
        final String FIRST_NAME = "first";
        final String LAST_NAME = "last";
        final int MAX = 10;

        for( int i = 1; i <= MAX; i++ )
        {
            //TODO: Set student id
            Student student = new Student();
            student.setFirstName( FIRST_NAME );
            student.setLastName( LAST_NAME );

            students.add( student );
        }
    }

    public StudentData()
    {
        loadData();
    }
}
