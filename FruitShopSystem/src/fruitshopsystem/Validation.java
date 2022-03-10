
package fruitshopsystem;

import java.util.Scanner;

public class Validation {
    public static int getInteger(String msg, int min, int max) {
        
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (min <= result && result <= max){
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
    
    public static double getDouble(String msg, double min, double max) {
        
        Scanner sc = new Scanner(System.in);
        double result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Double.parseDouble(sc.nextLine());
                if (min <= result && result <= max){
                    break;
                }
                System.err.println("Out of range");
            }
            catch (NumberFormatException e) {
                System.err.println("You must enter a real number");
            }
        }
        return result;
    }
    
    public static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        String result = "";
        while (true) {
            System.out.print(msg);
            result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                break;
            } else {
                System.err.println("Pleese enter a non-empty string");
            }
        }
        return result;
    }
    
    public static String getChoice(String x, String y){
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (true){
            try{
                choice = sc.nextLine();
                if(choice.equalsIgnoreCase(x) || choice.equalsIgnoreCase(y)){
                    break;
                }
                System.err.printf("You must enter %s or %s", x, y);
            }
            catch (Exception e){
                System.err.printf("You must enter %s or %s", x, y);
            }
        }
        return choice;
    }
}
