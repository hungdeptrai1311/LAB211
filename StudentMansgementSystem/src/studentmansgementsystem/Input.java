
package studentmansgementsystem;

import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    
    public int getChoice(int x, int y, String msg){
        int choice = 0;
        while(true){
            try{
                System.out.print(msg);
                choice = Integer.parseInt(sc.nextLine());
                if(choice >= x && choice <= y){
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
    
    public String getChoice2(String x, String y){
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
    
    public String fixName(){
        String name = sc.nextLine().trim();
        String clone = "";
        for(int i = 0; i < name.length(); i++){
            if(i == 0 || name.charAt(i - 1) == ' '){
                clone += Character.toUpperCase(name.charAt(i));
            }
            else{
                clone += Character.toLowerCase(name.charAt(i));
            }
        }
        return clone;
    }
}
