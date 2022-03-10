package employeemanagementsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    public static int getInteger(String msg, int min, int max) {

        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (min <= result && result <= max) {
                    break;
                }
                System.err.println("Out of range");
            } catch (NumberFormatException e) {
                System.err.println("You must enter an integer");
            }
        }
        return result;
    }

    public static String CheckDate(String Mess, String format) {
        Scanner sc = new Scanner(System.in);
        // parse 1 String -> Date
        SimpleDateFormat SDF = new SimpleDateFormat(format);
        // If you enter the wrong date like 30/02, it will be reported wrong and must be re-entered
        SDF.setLenient(false);
        String ret;
        do {
            System.out.print(Mess);
            try {
                ret = sc.nextLine();
                Date date = SDF.parse(ret);
                if(date.compareTo(SDF.parse("3/3/2004")) > 0 && ret.compareTo("3/3/2022") <= 0){
                    System.err.println("Not old enough");
                }
                else if(ret.compareTo("3/3/2022") > 0){
                    System.err.println("Don't enter future time");
                }
                else{
                    break;
                }
            } catch (Exception e) {
                System.err.println("Invalid date input, please try again!");
            }
        } while (true);
        return ret;
    }

    public static String checkMail(String msg) {
        Scanner sc = new Scanner(System.in);
        String result = "";
        while (true) {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.matches("[a-zA-Z]\\w+(\\.\\w+)*@(\\w+\\.)+\\w+")) {
                break;
            } else {
                System.err.println("You must enter the true format email");
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

    public static String getPhone(String msg) {
        Scanner sc = new Scanner(System.in);
        String result = "";
        while (true) {
            System.out.print(msg);
            result = sc.nextLine().trim();
            if (!result.isEmpty() && result.length() == 10) {
                int count = 0;
                for (Character c : result.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        count++;
                    }
                }
                if (count == 0) {
                    break;
                }
                else{
                    System.err.println("Please enter a phone number with only digit");
                }
            } else {
                System.err.println("Pleese enter a phone number with a length of 10");
            }
        }
        return result;
    }
    
    public static String getChoice(String msg, String x, String y){
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (true){
            try{
                System.out.print(msg);
                choice = sc.nextLine().toUpperCase();
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
    
    public static double getDouble(String msg, double min, double max) {

        Scanner sc = new Scanner(System.in);
        double result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (min <= result && result <= max) {
                    break;
                }
                System.err.println("Out of range");
            } catch (NumberFormatException e) {
                System.err.println("You must enter a number");
            }
        }
        return result;
    }
}
