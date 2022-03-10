package matrix;

import java.util.Scanner;

public class Function {

    public void input(int n, int m, int n1, int m1, int[][] arr, int[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Validation.getInteger("Enter the first matrix's element: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = Validation.getInteger("Enter the second matrix's element: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    public void add() {
        int n = Validation.getInteger("Enter the first matrix row: ", 1, Integer.MAX_VALUE);
        int m = Validation.getInteger("Enter the first matrix column: ", 1, Integer.MAX_VALUE);
        int n1 = Validation.getInteger("Enter the second matrix row: ", n, n);
        int m1 = Validation.getInteger("Enter the second matrix column: ", m, m);
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n1][m1];
        int[][] arradd = new int[n][m];
        input(n, m, n1, m1, arr1, arr2);
        display(arr1, n, m);
        System.out.print("+\n");
        display(arr2, n1, m1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arradd[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("=");
        display(arradd, n, m);
    }

    public void sub() {
        int n = Validation.getInteger("Enter the first matrix row: ", 1, Integer.MAX_VALUE);
        int m = Validation.getInteger("Enter the first matrix column: ", 1, Integer.MAX_VALUE);
        int n1 = Validation.getInteger("Enter the second matrix row: ", n, n);
        int m1 = Validation.getInteger("Enter the second matrix column: ", m, m);
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n1][m1];
        int[][] arrsub = new int[n][m];
        input(n, m, n1, m1, arr1, arr2);
        display(arr1, n, m);
        System.out.print("-\n");
        display(arr2, n1, m1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrsub[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        System.out.println("=");
        display(arrsub, n, m);
    }

    public void mul() {
        int n = Validation.getInteger("Enter the first matrix row: ", 1, Integer.MAX_VALUE);
        int m = Validation.getInteger("Enter the first matrix column: ", 1, Integer.MAX_VALUE);
        int n1 = Validation.getInteger("Enter the second matrix row: ", m, m);
        int m1 = Validation.getInteger("Enter the second matrix column: ", 1, Integer.MAX_VALUE);
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n1][m1];
        int[][] arrmul = new int[n][m1];
        input(n, m, n1, m1, arr1, arr2);
        display(arr1, n, m);
        System.out.print("*\n");
        display(arr2, n1, m1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m1; k++) {
                    arrmul[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        System.out.println("=");
        display(arrmul, n, m1);
    }

    public void display(int arr[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("[" + arr[i][j] + "]");
            }
            System.out.println();
        }
    }
}
