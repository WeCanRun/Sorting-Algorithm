package com.wuyi.notecode.sort;

public class SelectionSort1<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min]))
                    min = j;
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        SelectionSort1<Integer> sortInt = new SelectionSort1<>();
        Integer a[] = {4,9,1,2,5,8,7,6};
        sortInt.sort(a);
        System.out.println("最终结果：");
        sortInt.display(a);

        SelectionSort1<Double> sortDouble = new SelectionSort1<>();
        Double b[] = {2.2,58.3,6.0,56.1,5.1,93.63};
        sortDouble.sort(b);
        System.out.println("最终结果：");
        sortDouble.display(b);

        SelectionSort1<String> sortStr = new SelectionSort1<>();
        String s[] = {"d" , "f", "D" , "r" , "U"};
        sortStr.sort(s);
        System.out.println("最终结果：");
        sortStr.display(s);
    }
}
