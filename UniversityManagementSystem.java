package alok;

import java.util.HashSet;
import java.util.Set;

class Person 
{
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) 
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() 
    {
        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }
}

class Student extends Person 
{
    private String studentId;
    private Set<Course> courses;

    public Student(String name, int age, String gender, String studentId)
    {
        super(name, age, gender);
        this.studentId = studentId;
        this.courses = new HashSet<>();
    }

    public void enrollCourse(Course course)
    {
        courses.add(course);
        course.addStudent(this);
    }

    public void withdrawCourse(Course course) 
    {
        if (courses.contains(course))
        {
            courses.remove(course);
            course.removeStudent(this);
        }
    }

    public void displayCourses() 
    {
        System.out.println(getName() + "'s enrolled courses:");
        for (Course course : courses) 
        {
            System.out.println(course.getTitle());
        }
    }
}

class Teacher extends Person 
{
    private String employeeId;
    private Set<Course> courses;

    public Teacher(String name, int age, String gender, String employeeId)
    {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.courses = new HashSet<>();
    }

    public void assignCourse(Course course) 
    {
        courses.add(course);
        course.addTeacher(this);
    }

    public void withdrawCourse(Course course) 
    {
        if (courses.contains(course))
        {
            courses.remove(course);
            course.removeTeacher(this);
        }
    }

    public void displayCourses() 
    {
        System.out.println(getName() + "'s assigned courses:");
        for (Course course : courses) 
        {
            System.out.println(course.getTitle());
        }
    }
}

class Course 
{
    private String title;
    private String code;
    private Set<Student> students;
    private Set<Teacher> teachers;

    public Course(String title, String code) 
    {
        this.title = title;
        this.code = code;
        this.students = new HashSet<>();
        this.teachers = new HashSet<>();
    }

    public void addStudent(Student student) 
    {
        students.add(student);
    }

    public void removeStudent(Student student) 
    {
        students.remove(student);
    }

    public void addTeacher(Teacher teacher) 
    {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) 
    {
        teachers.remove(teacher);
    }

    public void displayStudents() 
    {
        System.out.println("Students enrolled in " + title + ":");
        for (Student student : students)
        {
            System.out.println(student.getName());
        }
    }
    
    public String getTitle() 
    {
        return title;
    }
}

public class UniversityManagementSystem 
{
    public static void main(String[] args)
    {
        
        Student student1 = new Student("Alice", 20, "Female", "S101");
        Student student2 = new Student("Bob", 22, "Male", "S102");

        Teacher teacher1 = new Teacher("Prof. Smith", 35, "Male", "T201");
        Teacher teacher2 = new Teacher("Dr. Johnson", 40, "Female", "T202");

        Course course1 = new Course("Introduction to Java", "CS101");
        Course course2 = new Course("Advanced Mathematics", "MATH201");

        student1.enrollCourse(course1);
        student2.enrollCourse(course2);

        teacher1.assignCourse(course1);
        teacher2.assignCourse(course2);

        student1.displayInfo();
        student1.displayCourses();

        teacher1.displayInfo();
        teacher1.displayCourses();

        course1.displayStudents();

        student1.withdrawCourse(course1);
        teacher1.withdrawCourse(course1);

        student1.displayCourses();
        teacher1.displayCourses();
        course1.displayStudents();
    }
}

