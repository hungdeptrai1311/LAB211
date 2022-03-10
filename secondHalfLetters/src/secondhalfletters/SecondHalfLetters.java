
package secondhalfletters;

import java.util.Scanner;

public class SecondHalfLetters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Enter your string: ");
        while(true){
            s = sc.nextLine().toLowerCase();
            if(!s.isEmpty()){
                break;
            }
            System.out.println("Please enter string again");
        }
        secondHalfLetters(s);
    }
    public static void secondHalfLetters(String s) {
        int count = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) >= 'n' && s.charAt(i) <= ('z') ){
                count++;
            }
        }
        System.out.println(count);
    }
}
