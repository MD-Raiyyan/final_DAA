import java.util.Scanner;

class QuickSort {

    static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {

        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (true) {

            while (i <= high && arr[i] < pivot)
                i++;

            while (j >= low && arr[j] > pivot)
                j--;

            if (i < j)
                swap(arr, i, j);
            else
                break;
        }

        swap(arr, low, j);

        return j;
    }

    static void swap(int arr[], int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Original Array:");

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        long start = System.nanoTime();

        quickSort(arr, 0, n - 1);

        long end = System.nanoTime();

        System.out.println("\nSorted Array:");

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println("\nExecution Time: " + (end - start) + " ns");

        sc.close();
    }
}
