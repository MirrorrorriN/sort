package com.mirror.sort;

import java.util.Comparator;

/**
 * (直接）插入排序
 * Created by MirrorrorriN @ 2020/1/7
 */
public class InsertionSort implements Sortable {

    private int gap=1;

    private int start=0;

    public void setGap(int gap) {
        this.gap = gap;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        int n = arr.length;
        for (int i = start+gap; i < n; i++) {
            int j = i - gap;
            T cur = arr[i];
            //从有序部分尾部向前寻找插入位置
            while (j >= 0 && cmp.compare(arr[j], cur) > 0) {
                arr[j + gap] = arr[j];
                j -= gap;
            }
            if (j != i - gap) {
                arr[j + gap] = cur;
            }
        }
    }
}
