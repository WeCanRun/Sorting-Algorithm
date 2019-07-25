package com.wuyi.notecode.sort;

import java.util.Random;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    T[] help;

    @Override
    public void sort(T[] nums) {
        help = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(T[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        // 给辅助数组赋值
        for (; k <= high; k++) {
            help[k] = nums[k];
        }

        k = low;
        while (k <= high) {
            if (i > mid) {
                nums[k] = help[j++];

            } else if (j > high) {
                nums[k] = help[i++];

            } else if (help[i].compareTo(help[j]) <= 0) {
                nums[k] = help[i++];

            } else {
                nums[k] = help[j++];

            }
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort<Integer> sortInt = new MergeSort<>();
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
    }
}
