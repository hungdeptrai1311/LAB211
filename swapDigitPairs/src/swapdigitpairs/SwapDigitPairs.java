package swapdigitpairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SwapDigitPairs {

    public static void main(String[] args) {
        swapDigitPairs(Validation.getInteger("Enter a positive integer number: ", 0, Integer.MAX_VALUE));
    }
    
    public static void swapDigitPairs(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        while(n > 0){
            arr.add(n % 10);
            n /= 10;
        }
        for (int i = 0; i < arr.size(); i += 2) {
            //12345 54321
            if (i != arr.size() - 1) {
                Collections.swap(arr, i, i + 1);
            }
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(arr.get(i));
        }
        System.out.println();
    }
}
