package com.mirror.sort;

import java.util.Comparator;

/**
 * Created by mirrordingjing @ 2020/1/9
 */
public class QuickSort implements Sortable {

    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        int n = arr.length;
        quickSort(arr, cmp, 0, n - 1);
    }

    private <T> void quickSort(T[] arr, Comparator<? super T> cmp, int low, int high) {
        if (low <= high) {
            int index = partition(arr, cmp, low, high);
            quickSort(arr, cmp, low, index - 1);
            quickSort(arr, cmp, index + 1, high);
        } else {
            return;
        }
    }

    private <T> int partition(T[] arr, Comparator<? super T> cmp, int low, int high) {
        T pivotVal = arr[low];
        int index = low;
        int pivot = low;
        for (int i = low + 1; i <= high; i++) {
            if (cmp.compare(pivotVal, arr[i]) > 0) {
                this.swap(arr, i, index);
                index++;
                pivot = i;
            }
        }
        swap(arr, index, pivot);
        return index;
    }

    private <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
