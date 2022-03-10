package reverseword;

import java.util.Scanner;

public class Validation {

    public static String getString() {
        String choice = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            choice = sc.nextLine().trim();
            if (choice.equals("")) {
                System.err.println("Your string is empty, please enter again");
                continue;
            }
            break;
        }
        return choice;
    }
}
