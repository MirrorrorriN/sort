package com.mirror.sort;

import java.util.Comparator;
import java.util.List;

/**
 * 冒泡排序
 * Created by mirrordingjing @ 2020/1/7
 */
public class BubbleSort<T> implements Sortable<T> {

    @Override
    public T[] sort(T[] arr, Comparator<? super T> cmp) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            //本次循环是否有过交换，无则表示已有序直接返回
            boolean flag=false;
            for(int j=0;j<n-1-i;j++){
                if (cmp.compare(arr[j],arr[j+1])>0){
                    T tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                    flag=true;
                }
            }
            if(!flag){
                return arr;
            }
        }
        return arr;
    }
}
