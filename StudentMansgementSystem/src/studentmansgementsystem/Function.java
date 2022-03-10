package studentmansgementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Function {

    ArrayList a = new ArrayList();
    Scanner sc = new Scanner(System.in);
    Input input = new Input();
    HashMap<Student, Integer> toc;

    public void getStudentIn4() {
        toc = new HashMap<>();
        Student student = new Student();
        System.out.print("Enter student's ID: ");
        student.setId(sc.nextLine().trim());
        String n = checkID(student.getId());
        if (!n.equalsIgnoreCase(" ")) {
            student.setName(n);
            System.out.print("Enter semester: ");
            student.setSemester(sc.nextLine().trim());
            System.out.print("Enter course: ");
            student.setCourse(sc.nextLine().toUpperCase().trim());
            System.out.println("\n------------------------------------");
            Integer t = toc.get(student);
            toc.put(student, t == null ? 1 : t + 1);
        } else {
            System.out.print("Enter student's name: ");
            student.setName(input.fixName());
            System.out.print("Enter semester: ");
            student.setSemester(sc.nextLine().trim());
            System.out.print("Enter course: ");
            student.setCourse(sc.nextLine().toUpperCase().trim());
            student.setAge(input.getChoice(1, 150, "Enter student's age: "));
            System.out.println("\n------------------------------------");
            a.add(student);
            Integer t = toc.get(student);
            toc.put(student, t == null ? 1 : t + 1);
        }
    }

    public void create() {
        for (int i = 0; i < 2; i++) {
            getStudentIn4();
        }
        String choice;
        do {
            System.out.print("Do you want to continue (Y/N)?");
            choice = input.getChoice2("Y", "N");
            if (choice.equalsIgnoreCase("y")) {
                getStudentIn4();
            } else {
                break;
            }
        } while (choice.equalsIgnoreCase("y"));
    }

    public String checkID(String key) {
        for (int i = 0; i < a.size(); i++) {
            if (key.equalsIgnoreCase(((Student) a.get(i)).getId())) {
                return ((Student) a.get(i)).getName();
            }
        }
        return " ";
    }

    public void report() {
        
    }

    public void findAndSort() {
        Collections.sort(a, new SortStudent());
        System.out.print("Enter student's name: ");
        String key = sc.nextLine();
        int count = 0;
        for (Object object : a) {
            if (((Student) object).getName().contains(key)) {
                count++;
                if (count == 1) {
                    System.out.println(object.toString());
                } else {
                    System.out.println(object.toString());
                }
            }
        }
        if (count == 0) {
            System.err.println("This name has not been existed");
        }
    }

}
