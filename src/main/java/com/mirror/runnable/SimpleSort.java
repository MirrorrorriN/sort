package com.mirror.runnable;

import com.mirror.sort.*;

/**
 * Created by MirrorrorriN @ 2020/1/7
 */
public class SimpleSort {
    public static void main(String[] args){
        Integer[] arr={5,1,4,2,3,7,10,9,6,7,4,8,11};
        Sortable sortable=new QuickSort();
        sortable.sort(arr,Integer::compareTo);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
