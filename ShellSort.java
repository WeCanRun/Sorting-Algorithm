package com.wuyi.notecode.sort;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        int h = 1;
        while (3 * h + 1 < n) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        ShellSort<Integer> sortInt = new ShellSort<>();
        Integer a[] = {4, 9, 1, 2, 5, 8, 7, 6};
        sortInt.sort(a);
        System.out.println("最终结果：");
        sortInt.display(a);

        ShellSort<Double> sortDouble = new ShellSort<>();
        Double b[] = {2.2, 58.3, 6.0, 56.1, 5.1, 93.63};
        sortDouble.sort(b);
        System.out.println("最终结果：");
        sortDouble.display(b);

        ShellSort<String> sortStr = new ShellSort<>();
        String s[] = {"d", "f", "D", "r", "U"};
        sortStr.sort(s);
        System.out.println("最终结果：");
        sortStr.display(s);
    }
}
