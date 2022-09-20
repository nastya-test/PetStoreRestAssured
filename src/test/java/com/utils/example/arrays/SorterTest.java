package com.utils.example.arrays;

import java.util.Arrays;

public class SorterTest {
    public static void main(String[] args) {

        int[] num = new int[4];
        num[0] = 1;
        num[1] = 256;
        num[2] = 4;
        num[3] = 100;

        int[] data = {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7};

        BubbleSorter.sort(data);
        System.out.println(Arrays.toString(data));
        }
}
