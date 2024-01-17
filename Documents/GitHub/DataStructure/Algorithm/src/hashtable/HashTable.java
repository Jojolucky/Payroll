package hashtable;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {
        HashTab hash = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: add employee");
            System.out.println("list: show employee");
            System.out.println("find: find employee");
            System.out.println("exit: return back");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("input id");
                    int id = scanner.nextInt();
                    System.out.println("input name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hash.add(emp);
                    break;
                case "list":
                    hash.list();
                    break;
                case "find":
                    System.out.println("input the id you want to find: ");
                    id = scanner.nextInt();
                    hash.findEmpById(id);
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}

// 创建hash table，用于管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size=size;
        empLinkedListArray = new EmpLinkedList[size];
        for(int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        // 根据员工的id 得到该员工应该加入到哪条链表
        int empLinkedListNO = hashFunction(emp.id);
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    // 遍历所有的链表，遍历hashtab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }

    // 根据输入的id查找雇员
    public void findEmpById(int id){
        int empLinkedListNO = hashFunction(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp != null){
            System.out.printf("In the No %d find the employee, his id is %d ", (empLinkedListNO+1),id);
        }else{
            System.out.println("Can not find the employee");
        }
    }

    // 编写一个散列函数，使用取模法
    public int hashFunction(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;

    }
}

// 创建EmpLinkedList, 表示链表
class EmpLinkedList {
    // 头指针， 执行第一个emp， 因此我们这个连标的head，是直接指向下一个emp
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list() {
        if (head == null) {
            System.out.println("The linkedlist is null");
            return;
        }
        System.out.println("The cur linkedlist is : ");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id = %d name = %s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println("\n");
    }

        // 根据id 查找雇员
        // 如果找到了就返回emp，，没有找到就返回null
        public Emp findEmpById(int id) {
            if (head == null) {
                System.out.println("The LinkedList is null");
                return null;
            }
            Emp curEmp = head;
            while (true) {
                if (curEmp.id == id) {
                    break;
                }
                if(curEmp.next == null){
                    curEmp = null;
                    break;
                }
                curEmp = curEmp.next;
            }
            return curEmp;

        }

    }
