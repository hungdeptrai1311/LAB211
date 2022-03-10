
package bubblesortalgorithm;

public class BubbleSortAlgorithm {

    public static void main(String[] args) {
        int n = Validation.getInteger("Enter number of array:", 0, Integer.MAX_VALUE);
        int[] arr = new int[n];
        //nhập min ,max từ user
        int min = Validation.getInteger("Enter min value:", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int max = Validation.getInteger("Enter max value:", min, Integer.MAX_VALUE);
        //dùng hàm 
        for (int i = 0; i < arr.length; i++) {
              arr[i]= (int) (Math.random() * (max - min +1)) + min;         
        }

        System.out.print("Unsorted array: ");
        display(arr);
        sort(arr);
        System.out.print("Sorted array: ");
        display(arr);
    }
 
//thuật toán bubble sort
    public static void sort(int[] arr){
        //{16,3,21,25,10}   
        //{3,16,21,25,10}
        //{3,16,21,10,25}    1
        
        //{3,16,10,21,25}
        //{3,10,16*,21,25}   2
        
        //{3,10,16,21,25}    3  
        
        //{3,10,16,21,25}    4
        
        //{3,10,16,21,25}    5     
        for(int i = 0; i < arr.length ;i++){
            for(int j = 0; j < arr.length -i -1;j++){ 
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp; 
                }
            }
        }
    }

    public static void display(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
   
    
}
