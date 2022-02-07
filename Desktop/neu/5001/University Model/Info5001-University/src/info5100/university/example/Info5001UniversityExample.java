/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        College coe=new College("Northeastern College of Engineering");
        
        Department is= coe.newDepartment("Information Systems");
        Department ses= coe.newDepartment("Software Engineering Systems");
        Department ds= coe.newDepartment("Data Science");
        coe.printDepartmentList();
        
        
        StudentDirectory sd1= is.getStudentDirectory();
        PersonDirectory pd1=is.getPersonDirectory();
        StudentDirectory sd2= ses.getStudentDirectory();
        PersonDirectory pd2=ses.getPersonDirectory();
        StudentDirectory sd3= ds.getStudentDirectory();
        PersonDirectory pd3=ds.getPersonDirectory();
    
        Person p1= new Person("NUQ2021001");
        StudentProfile sp1=sd1.newStudentProfile(p1);
        Person p2= new Person("NUQ2021002");
        StudentProfile sp2=sd1.newStudentProfile(p2);
        Person p3= new Person("NUQ2021003");
        StudentProfile sp3=sd1.newStudentProfile(p3);
        Person p4= new Person("NUQ2021004");
        StudentProfile sp4=sd2.newStudentProfile(p4);
        Person p5= new Person("NUQ2021005");
        StudentProfile sp5=sd2.newStudentProfile(p5);
        Person p6= new Person("NUQ2021006");
        StudentProfile sp6=sd2.newStudentProfile(p6);
        Person p7= new Person("NUQ2021007");
        StudentProfile sp7=sd3.newStudentProfile(p7);
        Person p8= new Person("NUQ2021008");
        StudentProfile sp8=sd3.newStudentProfile(p8);
        Person p9= new Person("NUQ2021009");
        StudentProfile sp9=sd3.newStudentProfile(p9);
        Person p10= new Person("NUQ2021010");
        StudentProfile sp10=sd3.newStudentProfile(p10);
        
        System.out.println("\n");
        System.out.println("----------Student List----------");
        coe.printAllStuedntList();
        
        
        CourseCatalog cc1=is.getCourseCatalog();
        CourseCatalog cc2=ds.getCourseCatalog();
        CourseCatalog cc3=ses.getCourseCatalog();
        
        cc1.newCourse("APP Modeling and Design","Info5001",8);
        cc1.newCourse("Application Engineering and Development","Info5100",4);
        cc1.newCourse("Data Science Engineering Methods and Tools","Info6105",4);
        cc2.newCourse("Supervised Machine Learning and Learning Theory","DS5220",4);
        cc3.newCourse("Concepts of Object-Oriented Design","CSYE620",4);
        
        System.out.println("\n");
        System.out.println("----------Course List----------");
        coe.printAllCourseList();
        
  
        
        List <CourseOffer> registionStatement = new ArrayList<>();
       
        CourseSchedule cs_is=is.newCourseSchedule("Fall2021");
        CourseSchedule cs_ses=ses.newCourseSchedule("Fall2021");
        CourseSchedule cs_ds=ds.newCourseSchedule("Fall2021");
        
        CourseOffer co1=cs_is.newCourseOffer("Info5001");
        CourseOffer co2=cs_is.newCourseOffer("Info5100");
        CourseOffer co3=cs_is.newCourseOffer("Info6105");
        CourseOffer co4=cs_ds.newCourseOffer("DS5220");
        CourseOffer co5=cs_ses.newCourseOffer("CSYE620");
        
        registionStatement.add(co1);
        registionStatement.add(co2);
        registionStatement.add(co3);
        registionStatement.add(co4);
        registionStatement.add(co5);

        co1.generatSeats(10);
        co2.generatSeats(8);
        co3.generatSeats(5);
        co4.generatSeats(5);
        co5.generatSeats(5);
        
        CourseLoad cl1=sp1.newCourseLoad("Fall2021");
        CourseLoad cl2=sp2.newCourseLoad("Fall2021");
        CourseLoad cl3=sp3.newCourseLoad("Fall2021");
        CourseLoad cl4=sp4.newCourseLoad("Fall2021");
        CourseLoad cl5=sp5.newCourseLoad("Fall2021");
        CourseLoad cl6=sp6.newCourseLoad("Fall2021");
        CourseLoad cl7=sp7.newCourseLoad("Fall2021");
        CourseLoad cl8=sp8.newCourseLoad("Fall2021");
        CourseLoad cl9=sp9.newCourseLoad("Fall2021");
        CourseLoad cl10=sp10.newCourseLoad("Fall2021");
        
        co1.assignEmptySeat(cl1);
        co1.assignEmptySeat(cl2);
        co1.assignEmptySeat(cl3);
        co2.assignEmptySeat(cl4);
        co2.assignEmptySeat(cl5);
        co3.assignEmptySeat(cl6);
        co3.assignEmptySeat(cl7);
        co4.assignEmptySeat(cl8);
        co4.assignEmptySeat(cl9);
        co5.assignEmptySeat(cl10);
        
        System.out.println("\n");
        System.out.println("----------Registion Statement----------");
        for(CourseOffer s : registionStatement){
            System.out.println("The occupied seats number of "+s.getCourseNumber()+" is "+s.getOccupiedSeatCount()+".");
        }
        
        System.out.println("\n");
        System.out.println("----------Total Revenue----------");
        System.out.println("The total revenue of all departments is: " + coe.CalculateTotalRevenue());
        
        
    }
}
       
    

        
        
                
                
                
                
                
             
               
                
                
                
                
         
//        Department department = new Department("Information Systems");
//        CourseCatalog coursecatalog = department.getCourseCatalog();
//        
//        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
//        
//        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
//
//        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
//        if (courseoffer==null)return;
//        courseoffer.generatSeats(10);
//        PersonDirectory pd = department.getPersonDirectory();
//        Person person = pd.newPerson("0112303");
//        StudentDirectory sd = department.getStudentDirectory();
//        StudentProfile student = sd.newStudentProfile(person);
//        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
////        
//        courseload.newSeatAssignment(courseoffer); //register student in class
//        
//        int total = department.calculateRevenuesBySemester("Fall2020");
//        System.out.println("Total: " + total);


