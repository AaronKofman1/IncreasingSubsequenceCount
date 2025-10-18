import java.util.*;

public class IncreasingSubsequenceCount {

    public static int countWays(int[] arr, int index, int prev) {
        if (index == arr.length) return 1; // Reached the end, one valid sequence found

        int count = 0;
        if (arr[index] == 0) { // If it's a zero, try all possible replacements
            for (int num = prev + 1; num <= 10; num++) {
                if (index + 1 < arr.length && arr[index + 1] != 0 && num >= arr[index + 1]) {
                    continue; // Ensure that the replacement keeps the sequence strictly increasing
                }
                count += countWays(arr, index + 1, num);
            }
        } else { // If it's a fixed number, just proceed if it's valid
            if (arr[index] <= prev) return 0; // Invalid sequence, return 0
            count += countWays(arr, index + 1, arr[index]);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Validate if replacement is possible
        for (int i = 1; i < N; i++) {
            if (arr[i] != 0 && arr[i] <= arr[i - 1]) {
                System.out.println(0); // Invalid sequence, no valid replacements possible
                scanner.close();
                return;
            }
        }

        System.out.println(countWays(arr, 0, 0));
        scanner.close();
    }
}
