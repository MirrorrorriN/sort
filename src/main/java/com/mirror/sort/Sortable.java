package com.mirror.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Created by MirrorrorriN @ 2020/1/7
 */
public interface Sortable {
    public <T> void sort(T[] arr, Comparator<? super T> cmp);
}
