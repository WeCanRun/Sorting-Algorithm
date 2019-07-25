package com.wuyi.notecode.sort;

import java.util.Random;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int n = nums.length - 1;
        for (int k = n / 2; k >= 0; k--) {
            sink(nums, k, n);
        }

        while (n >= 1) {
            swap(nums, 0, n--);
            sink(nums, 0, n);
        }
    }

    private void sink(T[] nums, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k + 1;
            if (j < n && less(nums[j], nums[j + 1]))
                j++;
            if (j > n || !less(nums[k], nums[j]))
                break;
            swap(nums, j, k);
            k = j;
        }
    }

    public static void main(String[] args) {
        HeapSort<Integer> sortInt = new HeapSort<>();
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
