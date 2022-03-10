package printsquare;

import java.util.Scanner;

public class PrintSquare {

    public static void main(String[] args) {
        int min = Validation.getInteger("Enter min value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int max = Validation.getInteger("Enter max value: ", min, Integer.MAX_VALUE);
        printSquare(min, max);
    }
    
    public static void printSquare(int min, int max){
        int n = max - min + 1;
        int[] arr = new int[n];
        //Tạo ra một mảng giá trị từ min đến max
        for (int i = 0; i < n; i++) {
            arr[i] += min;
            min ++;
        }
        //In ra hinh vuong
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(arr[j]);              
            }
            //min = 1 max = 5
            // 1 2 3 4 5
            // 2 3 4 5 1
            // 3 4 5 1 2
            for(int k = 0 ; k < i; k++){
                System.out.print(arr[k]);
            }
            System.out.println();
        }
    }
}
