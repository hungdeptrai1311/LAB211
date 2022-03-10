
package baicuacong;

import java.util.Scanner;

public class BaiCuaCong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("Enter matrix[" + i + "]" + "[" + j + "] : ");
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        int tmp = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = count; j < n; j++){
                a[i][j] = arr[j][i];
            }
        }
        String s = "";
        for(int i = 0;i < n; i++){
            for(int j = count; j < n - 1; j++){
                if(a[i][j] == 1 && a[i][j + 1] == 1){
                    s += "D";
                    count++;
                }
                else if(a[i][j] == 1 && a[i][j + 1] == 0){
                    break;
                }
                if(i != 0 && j == count && a[i][j] == 0){
                    tmp = -1;
                    break;
                }
                else if(i != 0 && j == count && a[i][j] == 1){
                    s += "R";
                    count++;
                }
                if(count == n - 2 && a[i][j + 1] == 1)
            }
            if(tmp == -1){
                break;
            }
        }
        if(tmp == -1){
            System.out.println("-1");
        }
        else{
            System.out.println(s);
        }
    }
    
}
