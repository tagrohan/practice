import java.util.Arrays;

public class OnArray {
    public static void main(String[] args) {
        subArraySum(new int[]{1,2,2});
    }

    private static void subArraySum(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                System.out.print(sum+" ");
            }System.out.println();
        }
    }

    // public static int kthSmallest(Integer[] arr, int l, int r, int k) {
    // System.out.println(kthSmallest(new Integer[] { 7, 10, 4, 3, 20, 15 }, 0, 5,
    // 3));
    // StringBuffer buffer = new StringBuffer(Arrays.toString(arr));
    // List<Integer> list = Arrays.asList(arr);
    // Collections.sort(list);
    // for (int var : list) {
    // System.out.println(var);
    // }
    // return 1;
    // }

    public static int[] runningSum(int[] nums) {
        // 1,1,1,1,1 -> [1, 2, 3, 4, 5] = [1,1+1,1+1+1 ...]
        // System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    private static void mainAndMaxInArray(int[] arr) {
        // mainAndMaxInArray(new int[] {1000, 11, 445, 1, 330, 3000});
        int min = arr[0], max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            } else if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max + "::::" + min);
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
