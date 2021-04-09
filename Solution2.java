import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// record breaker
//https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff08/0000000000387171#problem
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int times = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int z = 0; z < times; z++) {

            int len = in.nextInt();
            int[] visitors = new int[len];
            for (int l = 0; l < len; l++) {
                visitors[l] = in.nextInt();
            }

            int recordBreaksCount = 0;
            int previousRecord = 0;
            for (int i = 0; i < visitors.length; i++) {
                boolean greaterThanPreviousDays = i == 0 || visitors[i] > previousRecord;
                boolean greaterThanFollowingDay = i == visitors.length - 1 || visitors[i] > visitors[i + 1]; // short
                                                                                                             // circuiting
                                                                                                             // condition
                if (greaterThanPreviousDays && greaterThanFollowingDay) {
                    recordBreaksCount++;
                }
                previousRecord = Integer.max(previousRecord, visitors[i]);
            }
            System.out.println("Case #" + (z + 1) + ":" + " " + (recordBreaksCount));
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