
package swapdigitpairs;

import java.util.Scanner;

public class Validation {
    public static int getInteger(String msg, int x, int y){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(true){
            try{
                System.out.print(msg);
                choice = Integer.parseInt(sc.nextLine());
                if(choice > x && choice <= y){
                    break;
                }
                System.err.println("Out of range");
            }
            catch (Exception e){
                System.err.printf("You must enter an integer number from %d to %d\n", x, y);
            }
        }
        return choice;
    }
}
