package com.mirror.sort;

import java.util.Comparator;

/**
 * （2路）归并排序
 * 空间复杂度：临时的数组和递归时压入栈的数据占用的空间（n+logn）->空间复杂度为O(n)
 * 常见排序中时间效率仅次于快排
 * 真实生产环境会使用的排序算法
 * 外部排序中使用，内部排序类似场景会使用快排
 * Created by MirrorrorriN @ 2020/1/8
 */
public class MergeSort implements Sortable {

    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        this.mergeSort(arr, 0, arr.length - 1, cmp);
    }

    private <T> void mergeSort(T[] arr, int low, int high, Comparator<? super T> cmp) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid, cmp);
        mergeSort(arr, mid + 1, high, cmp);
        merge(arr, low, mid, high, cmp);
    }

    private <T> void merge(T[] arr, int low, int mid, int high, Comparator<? super T> cmp) {
        T[] tmp = (T[]) new Object[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high) {
            //注意处理相等的情况 保证稳定性
            if (cmp.compare(arr[i], arr[j]) > 0) {
                tmp[index] = arr[j];
                j++;
            } else {
                tmp[index] = arr[i];
                i++;
            }
            index++;
        }
        while (i <= mid) {
            tmp[index] = arr[i];
            i++;
            index++;
        }
        while (j <= high) {
            tmp[index] = arr[j];
            j++;
            index++;
        }
        for (int k = 0; k < tmp.length; k++) {
            arr[low + k] = tmp[k];
        }
    }
}
