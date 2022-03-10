package selectionsortalgorithm;

import java.util.Scanner;

public class SelectionSortAlgorithm {

    public static void main(String[] args) {
        int n = Validation.getInteger("Enter array length: ", 0, Integer.MAX_VALUE);
        int[] arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = Validation.getInteger("Enter arr elemrnt: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        System.out.print("Unsorted array: ");
        display(n, arr);
        selectionSort(n, arr);
        System.out.print("Sorted array: ");
        display(n, arr);
    }

    public static void display(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(", ");
            }
            if (i == n - 1) {
                System.out.print("]\n");
            }
        }
    }
    // 4 8 7 5
       
    // 4 8 7 5
    
    // 4 8 7 5
    
    // 4 5 7 8
    
    // 4 5 7 8
    
    public static void selectionSort(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[iMin] > arr[j]) {
                    iMin = j;
                }
            }
            if (i != iMin) {
                int tmp =arr[i];
                arr[i] = arr[iMin];
                arr[iMin] = tmp;
            }
        }
    }
}
