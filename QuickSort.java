package com.wuyi.notecode.sort;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    protected void sort(T[] nums, int low, int high) {
        if (low >= high)
            return;
        int j = help(nums, low, high);
        sort(nums, low, j - 1);
        sort(nums, j + 1, high);

    }

    private int help(T[] nums, int low, int high) {
        int i = low , j = high + 1;
        // T value = nums[low];
        T value = pivot(nums, low, high);
        while (true) {
            while (less(nums[++i], value) && i < high ) ;
            while (less(value, nums[--j]) && j > low ) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private T pivot(T[] nums, int left , int right) {

        int mid = ( left + right ) / 2;
        if(nums[mid].compareTo(nums[right]) > 0)
            swap(nums, mid , right);
        if(nums[left].compareTo(nums[right]) > 0)
            swap(nums, left , right);
        if(nums[mid].compareTo(nums[left]) > 0)
            swap(nums, mid, left);

        return nums[left];
    }
    public static void main(String[] args) {
        QuickSort<Integer> sortInt = new QuickSort<>();
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

        QuickSort<Double> sortDouble = new QuickSort<>();
        Double b[] = {5.2, 8.3, 6.9, 6.1, 5.1, 9.63};
        sortDouble.sort(b);
        System.out.println("最终结果：");
        sortDouble.display(b);
    }
}

