package com.wuyi.notecode.sort;

import java.util.Random;

public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {
    @Override
    protected void sort(T nums[], int low, int high) {
        if (low >= high)
            return;

        int lt = low, i = low + 1, gt = high;
        T value = nums[low];
        while (i <= gt) {
            int flag = nums[i].compareTo(value);
            if (flag < 0) {
                swap(nums, lt++, i++);
            } else if (flag > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, low, lt);
        sort(nums, lt + 1,high);
    }

    public static void main(String[] args) {
        ThreeWayQuickSort<Integer> sortInt = new ThreeWayQuickSort<>();
        Integer a[] = new Integer[1000];
        Random r = new Random();
        for (int i = 0; i < 1000; i++){
            a[i] = r.nextInt(1000);
        }
        sortInt.sort(a);
        boolean res = true;
        for (int i = 1; i < 1000; i++){
            if (a[i] < a[i - 1]) {
                res = false;
                break;
            }
        }
        System.out.println("最终结果：" + res);

        ThreeWayQuickSort<Double> sortDouble = new ThreeWayQuickSort<>();
        Double b[] = {5.2, 8.3, 6.9, 6.1, 5.1, 9.63};
        sortDouble.sort(b);
        System.out.println("最终结果：");
        sortDouble.display(b);
    }
}
