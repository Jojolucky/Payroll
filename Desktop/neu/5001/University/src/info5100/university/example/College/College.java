/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.College;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    String name;
    ArrayList<Department>departments;
    
    public College(String n){
        this.name=n;
        this.departments=new ArrayList<Department>();
    }
    
    public Department newDepartment(String n){
        Department newDept= new Department(n,this);
        departments.add(newDept);
        return newDept;
    }
    
    
    public void printDepartmentList(){
        
        System.out.println("---------"+this.name+"---------");
        System.out.println("                               ");
        System.out.println("---------Department List---------");
        for(Department d:departments){
            d.printDepartmentDetails();
        }
    }
    public void printAllStuedntList(){
       
        for(Department d: departments){
            d.printDepartmentStudentList();
                    
        }
    }
    
    public void printAllCourseList(){
       
        for(Department d: departments){
            d.printDepartmentCourseList();
                    
        }
    }

    public long calculateAllDepartmentTotalRevenue() {
        long sum=0;
        for(Department d: departments){
            sum+=d.caclulateRevenveByDepartment();
        }
        return sum;

    }
}
