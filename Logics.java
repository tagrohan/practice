import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Logics {

    public static void main(String[] args) {

        removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int var : nums) {
            set.add(var);
        }

        Object[] obj = set.toArray();
        for (int i = 0; i < obj.length; i++) {
            nums[i] = (int) obj[i];
        }

        return set.size();
    }

    private static int lowestPositiveMissing(int arr[], int size) {

        // not optimized
        // System.out.println(lowestPositiveMissing(new int[] { 1, 2, 3, 4, 5 }, 5));
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        for (int i = 1; i <= 1e6 + 2; i++) {
            map.put(i, true);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                map.remove(arr[i]);
            }
        }
        for (int i : map.keySet()) {
            System.out.println(i);
            break;
        }

        return -1;

        // Map<Integer, Boolean> map = new LinkedHashMap<>();
        // for (int i = 1; i < arr.length; i++) {
        // map.put(i, true);
        // }

        // for (int i = 0; i < arr.length; i++) {
        // if (map.get(arr[i]) != null) {
        // map.remove(arr[i]);
        // }
        // }
        // for (int i : map.keySet()) {
        // System.out.println(i + "->" + map.get(i));
        // break;
        // }
    }

    private static void findSubArraySum() {
        // mcrosoft, fb, google, visa
        // findSubArraySum(new int[] { 1, 2, 3, 7, 5 }, 12);
        // findSubArraySum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 15);
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scan.nextInt();
        A: for (int z = 0; z < t; z++) {

            int size = scan.nextInt();
            int s = scan.nextInt();
            int[] arr = new int[size];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    sum += arr[j];
                    if (sum == s) {
                        System.out.println((i + 1) + " " + (j + 1));
                        continue A;
                    }
                    if (sum > s) {
                        break;
                    }
                }
                sum = 0;
            }
            System.out.println("not available");
        }
    }

    private static void shortestMultipleOccur(int[] arr) {

        // occurence of a integer but if 2 found print first one
        // shortestMultipleOccur(new int[] { 1, 5, 3, 4, 3, 5, 6 });
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i : arr) {
            Integer occur = map.get(i);
            if (occur != null) {
                map.put(i, Integer.valueOf(occur + 1));
            } else {
                map.put(i, 1);
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i) > 1) {
                System.out.println(i + " -> " + map.get(i));
                break;
            }
        }

    }

    private static void frequencyCounter() {

        String[] str = { "look", "geeks" };
        Map<Character, Integer> map = new HashMap<>();

        for (String var : str) {
            for (int i = 0; i < var.length(); i++) {
                char ch = var.charAt(i);
                Integer frequency = map.get(ch);
                if (frequency != null) {
                    map.put(ch, Integer.valueOf(frequency + 1));
                } else {
                    map.put(ch, 1);
                }
            }
        }

        for (Character ch : map.keySet()) {
            System.out.println(ch + " -> " + map.get(ch));
        }

        // Map<String, String> map = new HashMap<>();
        // map.put("name", "value");
        // map.put("ant", "ant");
        // map.put("ant", "new value");

        // for (String str : map.keySet()) {
        // System.out.println(map.get(str));
        // }

    }
}
