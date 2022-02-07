/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Degree.Degree;
import info5100.university.example.Employer.EmployerDirectory;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {
    College college;
    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    EmployerDirectory employerdirectory;
    Degree degree;

    HashMap<String, CourseSchedule> mastercoursecatalog; //Key is semester;

    public Department(String n, College c) {
        college=c;
        name = n;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        degree = new Degree("MSIS");
        
    }
    public void addCoreCourse(Course c){
        degree.addCoreCourse(c);
        
    }
public void addElectiveCourse(Course c){
        degree.addElectiveCourse(c);
        
    }

    public College getCollege() {
        return college;
    }

    public String getName() {
        return name;
    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
    return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }
    
    
    public void printDepartmentDetails(){
 
        System.out.println("Deaprtment: "+name);
        
    }
    
    public void printDepartmentStudentList(){
        System.out.println("Department: "+ name);
        studentdirectory.printStudentList();
        System.out.println("\n");
    }
    
    public void printDepartmentCourseList(){
        System.out.println("Department: "+ name);
        coursecatalog.printCourseList();
        System.out.println("\n");
    }

    public long caclulateRevenveByDepartment() {
        long sum=0;
        for(String s:mastercoursecatalog.keySet()){
            sum+=mastercoursecatalog.get(s).calculateTotalRevenues();
        }
        return sum;
        
                
          
                

        
        
        
        
    }
}
