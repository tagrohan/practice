import java.util.Arrays;

public class OnArray {
    public static void main(String[] args) {
        System.out.println("working");

        
        
    }


    public static int[] runningSum(int[] nums) {
        // 1,1,1,1,1 -> [1, 2, 3, 4, 5] = [1,1+1,1+1+1 ...]
        // System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));
        for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i-1];
        }

        return nums;
    }



    




    private static void mainAndMaxInArray(int[] arr) {
        // mainAndMaxInArray(new int[] {1000, 11, 445, 1, 330, 3000});
        int min = arr[0], max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }else if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println(max +"::::"+ min);
    }

    private static void reverseArray(int[] arr) {
        int end = arr.length - 1;
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            // temp = arr[i];
            // arr[i] = arr[end];
            // arr[end] = temp;

            // arr[i] = arr[i] + arr[end];
            // arr[end] = arr[i] - arr[end];
            // arr[i] = arr[i] - arr[end];

            arr[i] = arr[i] + arr[end] - (arr[end] = arr[i]);

            end -= 1;
        }

        System.out.println(Arrays.toString(arr));
    }
}
