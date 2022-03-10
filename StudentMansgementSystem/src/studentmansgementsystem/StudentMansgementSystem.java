
package studentmansgementsystem;

public class StudentMansgementSystem {

    public static void main(String[] args) {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        Input input = new Input();
        int choice = 0;
        Function function = new Function();
        while(choice != 5){
            System.out.println("\t1. Create \n\t2. Find and Sort \n\t3. Update/Delete \n\t4. Report \n\t5. Exit");
            choice = input.getChoice(1, 5, "Enter your choice: ");
            switch (choice){
                case 1:
                    function.create();
                    break;
                case 2:
                    function.findAndSort();
                    break;
                case 4:
                    function.report();
                    break;
            }           
        }
    }
    
}
