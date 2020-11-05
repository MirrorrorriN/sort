package com.mirror.runnable;

import com.mirror.sort.*;


/**
 * Created by MirrorrorriN @ 2020/1/7
 */
public class SimpleSort {
    public static void main(String[] args){
        Integer[] arr={3,1,4,2,7,6,0};
        Sortable sortable=new QuickSort();
        //java自定义排序 Comparator与Comparable接口
        //Comparator 实现compare(Object o1,Object o2) 外部比较器 需要修改源码 自定义更灵活
        //Comparable 实现compareTo(Object o); 内部比较器 无需额外定义
        //lambda匿名函数？
        sortable.sort(arr, Integer::compareTo);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
