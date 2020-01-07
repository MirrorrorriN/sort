package com.mirror.sort;

import java.util.Comparator;

/**
 * （直接）选择排序
 * Created by mirrordingjing @ 2020/1/7
 */
public class SelectionSort<T> implements Sortable<T> {
    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (cmp.compare(arr[index], arr[j]) > 0) {
                    index = j;
                }
            }
            if (index != i) {
                T tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
