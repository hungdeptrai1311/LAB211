package employeemanagementsystem;

import java.util.Scanner;

public class EmployeeManagementSystem {

    public static int getMenuChoice() {
        System.out.println("Main menu:\n \t1. Add employees\n \t2. Update employees\n \t3. Remove employees\n \t4. Search employees\n \t5. Sort employees by salary\n \t6. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = Validation.getInteger("Enter menu choice: ", 1, 7);
        return choice;
    }

    public static void main(String[] args) {
        Function f = new Function();
        int choice = 0;
        while (choice != 6) {
            choice = getMenuChoice();
            switch (choice) {
                case 1:
                    f.add();
                    break;
                case 2:
                    f.update();
                    break;
                case 3:
                    f.remove();
                    break;
                case 4:
                    f.search();
                    break;
                case 5:
                    f.sort();
                    break;
                case 7:                    
                    f.display();
                    break;
            }
        }
    }

}
