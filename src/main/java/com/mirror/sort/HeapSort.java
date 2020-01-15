package com.mirror.sort;

import java.util.Comparator;

/**
 * @author DJ
 * @date 2020/1/16.
 */
public class HeapSort implements Sortable {
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        int n = arr.length;
        int len = n;
        this.buildMaxHeap(arr, n, cmp);
        for (int i = n - 1; i >= 1; i--) {
            this.swap(arr, 0, i);
            len--;
            this.heapify(arr, 0, len, cmp);
        }
    }

    /**
     * 构造大顶堆
     */
    private <T> void buildMaxHeap(T[] arr, int len, Comparator<? super T> cmp) {
        for (int i = len / 2; i >= 0; i--) {
            this.heapify(arr, i, len, cmp);
        }
    }

    private <T> void heapify(T[] arr, int i, int len, Comparator<? super T> cmp) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largestIndex = i;
        if (left < len && cmp.compare(arr[largestIndex], arr[left]) < 0) {
            largestIndex = left;
        }
        if (right < len && cmp.compare(arr[largestIndex], arr[right]) < 0) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            heapify(arr, largestIndex, len, cmp);
        }
    }

    private <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
