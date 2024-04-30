package Serge.Student.File.Reader;

import java.util.Comparator;

public class MarksCompare implements Comparator<Student> {

    public int compare(Student s1, Student s2){
        return  s2.marks-s1.marks;

    }
}
