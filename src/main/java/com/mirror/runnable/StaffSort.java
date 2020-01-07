package com.mirror.runnable;

import com.mirror.model.StaffDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mirrordingjing @ 2020/1/3
 */
public class StaffSort {
    private static final List<String> names = Arrays.asList
            ("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public static void main(String[] args) {
        List<StaffDTO> staffList = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            int age = (int) (Math.random() * 100);
            int index = (int) (Math.random() * 26);
            staffList.add(new StaffDTO(age, names.get(index)));
        }
        staffList=staffList.stream().sorted(Comparator.comparing(StaffDTO::getAge).thenComparing(StaffDTO::getName)).collect(Collectors.toList());
        for (StaffDTO staffDTO : staffList) {
            System.out.println("[age] " + staffDTO.getAge() + " [mark] " + staffDTO.getName());
        }
    }
}
