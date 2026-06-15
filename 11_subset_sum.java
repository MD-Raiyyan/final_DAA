import java.util.*;

public class SubsetSum {

    static int n;
    static int[] arr;

    static boolean subsetSum(int index, int sum, int target) {

        // Target found
        if (sum == target)
            return true;

        // End of array or sum exceeded
        if (index == n || sum > target)
            return false;

        // Include current element
        if (subsetSum(index + 1, sum + arr[index], target))
            return true;

        // Exclude current element
        if (subsetSum(index + 1, sum, target))
            return true;

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        long start = System.nanoTime();

        boolean ans = subsetSum(0, 0, target);

        long end = System.nanoTime();

        if (ans)
            System.out.println("Subset exists");
        else
            System.out.println("Subset does not exist");

        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}
