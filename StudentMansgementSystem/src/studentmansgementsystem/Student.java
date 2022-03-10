
package studentmansgementsystem;

import java.util.Comparator;

public class Student{
    private String id;
    private String name;
    private String semester;
    private String course;
    private int age;

    public Student() {
    }

    public Student(String id, String name, String semester, String course, int age) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

    @Override
    public String toString() {
        return String.format("%20s %10s", name, course);
    }

    @Override
    public int hashCode() {
        
    }

    
    
}
