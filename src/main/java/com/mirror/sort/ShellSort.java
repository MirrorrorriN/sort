package com.mirror.sort;

import java.util.Comparator;

/**
 * 希尔排序
 * 分组插入排序
 * 平均时间复杂度O(n^s)(1<s<=2)
 * s与使用的增量序列有关
 * gap=1时s=2
 * 使用Hibbard序列时s=5/4（gap_i=2^i−1）
 * 此时最环时间复杂度 O(n^(3/2))
 * Created by MirrorrorriN @ 2020/1/8
 */
public class ShellSort implements Sortable {

    private int gap;

    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        this.gap=arr.length/2;
        while(this.gap>=1){
            for(int i=0;i<gap;i++) {
                InsertionSort sortable = new InsertionSort();
                sortable.setGap(this.gap);
                sortable.setStart(i);
                sortable.sort(arr, cmp);
            }
            gap/=2;
        }
    }
}
