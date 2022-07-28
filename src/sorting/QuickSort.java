package sorting;

public class QuickSort {
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int getQuickSortPartition(int[] arr, int low, int high) {
        //Best O(NlogN)
        //Worst O(n^2)
        //using Partition way


        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = getQuickSortPartition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
