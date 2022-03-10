
package selectionsortalgorithm;

import java.util.Scanner;

public class Validation {
    //nhập vào một số integer và kiểm tra 
    public static int getInteger(String msg, int min, int max) {
        
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (min < result && result < max){
                    break;
                }
                System.err.println("Out of range");
            }
            catch (NumberFormatException e) {
                System.err.println("You must enter an integer");
            }
        }
        return result;
    }
}
