
package matrix;

public class Matrix {

    public static void main(String[] args) {
        int choice = 0;
        Function f = new Function();
        while(choice != 4){
            choice = getChoice();
            switch(choice){
                case 1:
                    f.add();
                    break;
                case 2:
                    f.sub();
                    break;
                case 3:
                    f.mul();
                    break;
            }
        }
    }
    
    public static int getChoice(){
        System.out.println("MAIN MENU\n \t1. Addition matrixes\n \t2. Subtraction matrixes\n \t3. Multiplication matrixes\n \t4. Exit");
        int choice = Validation.getInteger("Enter your choice: ", 1, 4);
        return choice;
    }
}
