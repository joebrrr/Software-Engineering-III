import org.joda.time.LocalDate;
import java.util.ArrayList;

public class CourseProgramme {
    private String courseName;
    private ArrayList<Student> students;
    private ArrayList<Module> module;
    private LocalDate startDate, endDate;

    public CourseProgramme(String courseName, LocalDate startDate, LocalDate endDate) {
        this.module = new ArrayList<Module>();
        this.students = new ArrayList<Student>();
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    //Design choice: courses exist before modules, therefore the module will be added to the course and not vice-versa, meaning the course object should handle
    //the logic of adding itself to the modules 'CoursesAssociated' array
    public void addModule(Module mod) {
        module.add(mod);
        mod.addCourse(this);
    }

    public ArrayList<Module> getModule() {
        return module;
    }

    public void addStudent(Student stud) { students.add(stud); }

    public ArrayList<Student> getStudents() {
        return students;
    }


    @Override
    public String toString(){
        String studentsEnrolled = "";
        String modules = "";

        for(Student student : students) {
            studentsEnrolled += "\n" + student;
        }

        for(Module moduleAssociated : module){
            modules += "\n" + moduleAssociated;
        }
        return "Course name: " + getCourseName() + "\nStudents Enrolled in course: " + studentsEnrolled + "\nModules Associated with this course: " + modules;
    }
}
