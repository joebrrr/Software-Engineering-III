import java.util.ArrayList;

public class Module {
    private String moduleName;
    private final int ID;
    private ArrayList<Student> studentsEnrolled;
    private ArrayList<CourseProgramme> coursesAssociated;
    private Lecturer taughtBy;

    public Module(String moduleName, int ID, Lecturer taughtBy) {
        this.moduleName = moduleName;
        this.ID = ID;
        this.studentsEnrolled = new ArrayList<Student>();
        this.coursesAssociated = new ArrayList<CourseProgramme>();
        this.taughtBy = taughtBy;

        //add this module to the lecturer automatically
        this.taughtBy.addModule(this);
    }

    public int getID() { return ID; }

    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }

    public void addStudent(Student student) { studentsEnrolled.add(student); }
    public ArrayList<Student> getStudentsEnrolled() { return studentsEnrolled; }

    public void addCourse(CourseProgramme course) { coursesAssociated.add(course); }
    public ArrayList<CourseProgramme> getCoursesAssociated() { return coursesAssociated; }

    public Lecturer getTaughtBy() { return taughtBy; }


    @Override
    public String toString() {
        String students = "";
        String lecturers = "";
        String courses = "";

        for(Student student : studentsEnrolled) {
            students += "\n" + student;
        }

        for(CourseProgramme course : coursesAssociated) {
            courses += "\n" + course;
        }

        return "Module name: " + getModuleName() + "\nModule ID: " + getID() + "\nCourses Associated with this module: " + courses + "\nTaught by: " + lecturers + "\nStudents Enrolled: " + students ;
    }
}
