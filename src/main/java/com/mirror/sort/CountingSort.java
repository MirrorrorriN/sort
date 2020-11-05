package com.mirror.sort;

import java.util.Comparator;

/**
 * Created by mirrordingjing @ 2020/1/16
 */
public class CountingSort implements Sortable {
    private int minVal = Integer.MAX_VALUE;
    private int maxVal = Integer.MIN_VALUE;

    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        this.findMinMax(arr, cmp);
        int n = this.maxVal - this.minVal + 1;
        int tmp[]=new int[n];

    }

    private <T> void findMinMax(T[] arr, Comparator<? super T> cmp) {
        for (int i = 0; i < arr.length; i++) {
            int cur = Integer.valueOf(arr[i].toString());
            if (Integer.compare(minVal, cur) > 0) {
                minVal = cur;
            }
            if (Integer.compare(maxVal, cur) < 0) {
                maxVal = cur;
            }
        }
    }


}
