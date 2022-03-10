
package reverseword;

import java.util.Scanner;

public class ReverseWord {
    
    public static void main(String[] args) {
        String result = "";
        String s = Validation.getString();
        String[] str = s.split("[.!?;]+");
        //Hung dep trai. hai ba bon ? abc xyz
        String sign = "!.?";
        int x = 0;
        //lấy số dấu trong s
        for (int i = 0; i < s.length(); i++) {
            if (sign.contains("" + s.charAt(i))) {
                x++;
            }
        }
        char[] signOfS = new char[x];
        x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sign.contains("" + s.charAt(i))) {
                signOfS[x] = s.charAt(i);
                x++;
            }
        }
        x = signOfS.length - 1;
        //ABC xyz. alo alo. 123
        for(int i = str.length - 1; i >= 0; i--){
            String clone = "";
            String[] subString = str[i].trim().split("\\s+");
            for(int j = subString.length - 1; j >= 0; j--){
                clone += subString[j] + " ";
            }
            result += clone.substring(0, 1).toUpperCase() + clone.substring(1).toLowerCase().trim();
            if(x >= 0){
                result += signOfS[x] + " ";
                x--;
            }
        }
        System.out.println(result);
    }    
}
