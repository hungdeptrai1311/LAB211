package printreverse;

import java.util.Scanner;

public class PrintReverse {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        printReverse(s);
    }
    
    public static void printReverse(String s) {
        String str = "";
        if (!s.equals("")) {
            for (int i = s.length() - 1; i >= 0; i--) {
                str += s.charAt(i);
            }
            System.out.println(str);
        }
    }
}
