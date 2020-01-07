package com.mirror.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Created by mirrordingjing @ 2020/1/7
 */
public class BubbleSort<T> implements Sortable<T> {

    @Override
    public T[] sort(T[] arr, Comparator<? super T> cmp) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if (cmp.compare(arr[i],arr[j])>0){
                    T tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        return null;
    }
}
