

public class BinarySearch {
    public static void main(String[] args) {

        System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
    }

    private static int binarySearch(int[] arr, int key) {
        int start = 0, end = arr.length - 1, middle = arr.length / 2;

        while (start <= end) {
            if (key == arr[middle]) {
                return middle;
            } else if (key == arr[start]) {
                return start;
            } else if (key == arr[end]) {
                return end;
            } else if (key > arr[middle]) {
                start = key;
            } else {
                end = key;
            }
            middle = (start + end) / 2;
        }

        return -1;
    }
}
