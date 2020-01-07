package com.mirror.sort;

import java.util.Comparator;

/**
 * (直接）插入排序
 * Created by mirrordingjing @ 2020/1/7
 */
public class InsertionSort<T> implements Sortable<T> {
    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            T cur = arr[i];
            //从有序部分尾部向前寻找插入位置
            while (j >= 0 && cmp.compare(arr[j], cur) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            if (j != i - 1) {
                arr[j + 1] = cur;
            }
        }
    }
}
