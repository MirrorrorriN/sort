package com.mirror.sort;

import java.util.Comparator;
import java.util.List;

/**
 * 冒泡排序
 * Created by MirrorrorriN @ 2020/1/7
 */
public class BubbleSort implements Sortable {

    @Override
    public <T> void sort(T[] arr, Comparator<? super T> cmp) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            //本次循环是否有过交换，无则表示已有序直接返回
            boolean flag=false;
            //每次迭代将最大值冒到尾部
            for(int j=0;j<n-1-i;j++){
                if (cmp.compare(arr[j],arr[j+1])>0){
                    T tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                    flag=true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
}
