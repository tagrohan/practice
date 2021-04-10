import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Logics {
    public static void main(String[] args) {

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
