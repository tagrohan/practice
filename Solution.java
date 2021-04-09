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
