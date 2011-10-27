package toberemoved.student;

import toberemoved.Data.StudentData;
import java.util.ArrayList;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
public class StudentRepository
{
    //    @Inject
    StudentData studentData = new StudentData();

    //Get all students
    public ArrayList<Student> getAllStudents()
    {
        return studentData.getStudents();
    }

    //Find s student given the id
    public Student findStudentId( String Id )
    {
        Student student = null;

        //Loop through rooms and exit when Id matches
        for( Student s : getAllStudents() )
        {
            if( s.getId().equals( Id ) )
            {
                student = s;
                break;
            }
        }

        return student;
    }
}
