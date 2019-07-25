package com.wuyi.notecode.sort;

import java.util.Random;

public class InsertionSort1<T extends Comparable<T>> extends Sort<T>  {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++){
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--){
                swap(nums,j, j - 1);
            }
        }
    }
    public static void main(String[] args) {
        InsertionSort1<Integer> sortInt = new InsertionSort1<>();
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
