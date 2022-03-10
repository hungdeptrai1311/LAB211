package employeemanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Function {

    ArrayList<Employee> list = new ArrayList();

    public void add() {
        Employee e = new Employee();
        while (true) {
            e.setId(Validation.getString("Enter employee's ID: "));
            if (checkId(e.getId()) == -1) {
                break;
            }
            System.out.println("This ID has been existed. Please enter another ID!");
        }
        e.setFirstName(Validation.getString("Enter employee's first name: "));
        e.setLastName(Validation.getString("Enter employee's last name: "));
        e.setPhone(Validation.getPhone("Enter employee's phone number: "));
        e.setEmail(Validation.checkMail("Enter employee's email: "));
        e.setAddress(Validation.getString("Emter employee's address: "));
        e.setDOB(Validation.CheckDate("Enter employee's date of birth: ","dd/MM/yyyy"));
        e.setSex(Validation.getChoice("Enter employee's sex: ", "F", "M"));
        e.setSalary(Validation.getDouble("Enter employee's salary: ", 0, Double.MAX_VALUE));
        e.setEgency(Validation.getString("Enter employee's egency: "));
//        e.setId("123");
//        e.setFirstName("hai");
//        e.setLastName("nam");
//        e.setPhone("1234567890");
//        e.setEmail("huongprowar@gmail.com");
//        e.setAddress("address");
//        e.setDOB("12/12/2002");
//        e.setSex("f");
//        e.setSalary(123);
//        e.setEgency("123");
        list.add(e);
        System.out.println("Employee is added");
    }

    public void display() {
        System.out.printf("%15s | %15s | %15s | %15s | %30s | %30s | %20s | %5s | %15s | %15s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "Date Of Birth", "Sex", "Salary", "Egency");
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }

    public int checkId(String s) {
        for (int i = 0; i < list.size(); i++) {
            if (s.equalsIgnoreCase(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee's ID you want to update: ");
        String s = sc.nextLine().trim();
        int i = checkId(s);
        if (i != -1) {
            list.get(i).setFirstName(Validation.getString("Enter employee's first name: "));
            list.get(i).setLastName(Validation.getString("Enter employee's last name: "));
            list.get(i).setPhone(Validation.getPhone("Enter employee's phone number: "));
            list.get(i).setEmail(Validation.checkMail("Enter employee's email: "));
            list.get(i).setAddress(Validation.getString("Emter employee's address: "));
            list.get(i).setDOB(Validation.CheckDate("Enter employee's date of birth: ", "dd/MM/yyyy"));
            list.get(i).setSex(Validation.getChoice("Enter employee's sex: ", "F", "M"));
            list.get(i).setSalary(Validation.getDouble("Enter employee's salary: ", 0, Double.MAX_VALUE));
            list.get(i).setEgency(Validation.getString("Enter employee's egency: "));
            System.out.println("Update successfully");
        } else {
            System.err.println("This ID is not exist!!!");
        }
    }

    public void remove() {
        System.out.print("Enter employee's ID you want to remove: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int i = checkId(s);
        if (i != -1) {
            list.remove(i);
            System.out.println("Remove successfully!!!");
        } else {
            System.out.println("This ID is not exist!!!");
        }
    }

    public void search() {
        System.out.print("Enter employee's name you want to search: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        boolean isExist = false;
        for (Employee employee : list) {
            if (employee.getFirstName().contains(s) || employee.getLastName().contains(s)) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.printf("%15s | %15s | %15s | %15s | %30s | %30s | %20s | %5s | %15s | %15s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "Date Of Birth", "Sex", "Salary", "Egency");
            for (Employee employee : list) {
                if (employee.getFirstName().contains(s) || employee.getLastName().contains(s)) {
                    System.out.println(employee.toString());
                }
            }
        }
        else{
            System.err.println("This name is not available in list!!!");
        }
    }
    
    public void sort(){
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size() - i -1;j++){
                if(list.get(j).getSalary() < list.get(j + 1).getSalary()){
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        System.out.println("Sort successfully !!!");
    }
}
