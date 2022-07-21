package sorting;

import java.util.Arrays;

public class Sorting {

    public int[] getInsertionSort(int[] arr) {
        //Best O(n)
        //Worst O(n^2)
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }

        return arr;
    }

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
