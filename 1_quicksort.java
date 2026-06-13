import java.util.Scanner;

class QuickSort {

    static int partition(int arr[], int low, int high) {

        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (true) {

            while (i <= high && arr[i] < pivot)
                i++;

            while (arr[j] > pivot)
                j--;

            if (i >= j)
                break;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long start = System.nanoTime();

        quickSort(arr, 0, n - 1);

        long end = System.nanoTime();

        System.out.println("Sorted Array:");

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println("\nExecution Time: " + (end - start) + " ns");

        sc.close();
    }
}
