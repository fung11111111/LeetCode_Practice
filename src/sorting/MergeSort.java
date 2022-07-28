package sorting;

public class MergeSort {
    //Best and Worst O(NlogN)

    // l - m is the first subArr
    // m+1 - r is the second subArr
    public void merge(int arr[], int l, int m, int r) {
        // size of two subArr
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[m + 1 + i];
        }

        int fIdxLeft = 0, fIdxRight = 0;

        int k = l;
        while (fIdxLeft < n1 && fIdxRight < n2) {
            if (leftArr[fIdxLeft] <= rightArr[fIdxRight]) {
                arr[k] = leftArr[fIdxLeft];
                fIdxLeft++;
            } else {
                arr[k] = rightArr[fIdxRight];
                fIdxRight++;
            }
            k++;
        }

        while (fIdxLeft < n1) {
            arr[k] = leftArr[fIdxLeft];
            fIdxLeft++;
            k++;
        }

        while (fIdxRight < n2) {
            arr[k] = rightArr[fIdxRight];
            fIdxRight++;
            k++;
        }

    }

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r)/ 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);

        }
    }


}
