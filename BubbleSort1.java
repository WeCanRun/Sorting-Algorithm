package com.wuyi.notecode.sort;

public class BubbleSort1<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        boolean isSorted = false;

        for (int i = 0; i < n - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 1; j < n - i; j++) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                    isSorted = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        BubbleSort1<Integer> sortInt = new BubbleSort1<>();
        Integer a[] = {4, 9, 1, 2, 5, 8, 7, 6};
        sortInt.sort(a);
        System.out.println("最终结果：");
        sortInt.display(a);

        BubbleSort1<Double> sortDouble = new BubbleSort1<>();
        Double b[] = {2.2, 58.3, 6.0, 56.1, 5.1, 93.63};
        sortDouble.sort(b);
        System.out.println("最终结果：");
        sortDouble.display(b);

        BubbleSort1<String> sortStr = new BubbleSort1<>();
        String s[] = {"d", "f", "D", "r", "U"};
        sortStr.sort(s);
        System.out.println("最终结果：");
        sortStr.display(s);
    }
}
