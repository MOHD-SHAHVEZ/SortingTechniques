package SortingRecursion;


public class MergeSort {

    public static void divide(int arr[], int start, int end) {
        // base case: 
        if(start == end) return; 

        // calculate the mid : start + (end - start) / 2  // --> 0 + (8 - 0) / 2 = 4 
        int mid = start + (end - start) / 2; 

        // left part call: 
        divide(arr, start, mid); // divide in left part : 
        divide(arr, mid + 1, end); // divide in right part: 
        merge(arr, start, end, mid);
    }

    public static  void merge(int arr[], int start, int end, int mid) {
        int temp[] = new int[(end - start + 1)]; 
        int i = start; // left  part
        int j = mid + 1;  // right part 
        int k = 0;  // temp array

        while(i <= mid && j <= end) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;  
            } else {
                temp[k] = arr[j]; 
                j++; 
            }
            k++; 
        }
        
        // if Left part have more element after compare and swap: 
        while(i <= mid) {
            temp[k++] = arr[i++]; 
        }

        // if right part have more element adter compare and swap: 
        while(j <= end) {
            temp[k++] = arr[j++]; 
        }

        // copy temp value into original array: 
        for(k = 0, i = start; k < temp.length; k++, i++) {
            arr[i] = temp[k]; 
        }

        printArr(arr);
    }

    public static void printArr(int arr[]) {

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int arr[] = {1,8,4,2,9,4,6,3}; 
        int start = 0; 
        int end = arr.length-1; 
        divide(arr, start, end);
        // printArr(arr);

    }
    
}
