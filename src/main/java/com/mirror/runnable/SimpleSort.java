package com.mirror.runnable;

import com.mirror.sort.BubbleSort;
import com.mirror.sort.Sortable;

/**
 * Created by mirrordingjing @ 2020/1/7
 */
public class SimpleSort {
    public static void main(String[] args){
        Integer[] arr={1,4,2,3,6,7,4};
        Sortable<Integer> sortable=new BubbleSort<>();
        sortable.sort(arr,Integer::compareTo);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
