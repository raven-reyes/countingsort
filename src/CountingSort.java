import java.util.Arrays;

public class CountingSort {
        public static void main(String [] args) {
        	// initialize the array to be sorted 
            int arr[]={1, 2, 8, 3, 1, 4,6};
            
            // find the maximum element in the array
            int max = arr[0];
            for(int i = 1; i < arr.length ; i++) {
                if(arr[i] > max)
                  max=arr[i];
                }
                // create a count array of size (max+1) to store the occurrence of every element .the count array is first initialized to zeros.
                int count [] = new int [max +1];
                for(int i = 0; i<max;i++){
                    count[i] = 0;
                   
                }
                // code for counting occurrence of every element by incrementing the value on the position  count[arr[i]]
                   for(int i = 0; i < arr.length;i++){
                       count[arr[i]]++;
                   }
                   // applying prefix sums to the countArray
                   // Prefix sums are basically formed when we add each of the previous numbers in the array onto the next accumulatively.
                   //It helps in placing the elements into the correct index of the sorted array.
                   // this code overwrites the occurrence count
                   // the cumulative count starts from (i=1); // (i=0) maintains its original value
                   for(int i = 1; i <= max; i++){
                       count[i] = count[i] + count[i-1];
                   }
                   
                   // we now create an output array to store the sorted original array .
                   // length of this output array is equals to the length of the original array
                   // we first initialize the output array to zeros
                   int outputArray [] = new int[arr.length];
                   for(int i = 0 ; i < arr.length ; i++){
                       outputArray[i] = 0;
                   }
                   // to maintain the stability of the array , we start sorting the original array from the end.
                     for(int i = arr.length -1 ; i >=0 ; i--){
                    	 // we take an element from the original array(from the end) and check its value in the count array
                    	 // then place that current element arr[i] at that  specific value  (count [arr[i]- 1])  in the output array
                    	 //(count[arr[i] -1]) is treated as an index in the output array
                         outputArray[count[arr[i]] -1] = arr[i];
                         // after placing the element at its correct position , decrease its count(cumulative count) by one
                         count[arr[i]]--; // decrementing the count of (count[arr[i] -1])
                     }
                     // we now copy the values of the  output array into the original array (arr) and print the sorted array
                     System.out.print("the original array is : " + Arrays.toString(arr));
                     System.out.println();
                     System.out.println("the sorted array is : ");
                   for(int i = 0 ; i<arr.length;i++){
                       arr[i] = outputArray[i];
                       System.out.print( + arr[i] + ", ");
                   }


        }
                }






	
	
	
	
	

