import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int times = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int z = 0; z < times; z++) {

            int len = in.nextInt();
            int[] arr = new int[len];
            for (int l = 0; l < len; l++) {
                arr[l] = in.nextInt();
            }

            int diff = arr[1] - arr[0];
            int occur = 0, maxOccur = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] == diff) {
                    occur += 1;
                } else {
                    diff = arr[i] - arr[i - 1];
                    occur = 1;
                }
                if (maxOccur < occur) {
                    maxOccur = occur;
                }
            }
            System.out.println("Case #" + (z + 1) + ":" + " " + (maxOccur + 1));

        }

    }
}

// test cases
// 4
// 7
// 10 7 4 6 8 10 11
// 4
// 9 7 5 3
// 9
// 5 5 4 5 5 5 4 5 6
// 10
// 5 4 3 2 1 2 3 4 5 6