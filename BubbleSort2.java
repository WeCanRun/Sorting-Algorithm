package com.wuyi.notecode.sort;

public class BubbleSort2<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        boolean isSorted = false;

        int low = 0, high = n - 1;
        while (low < high && !isSorted) {
            isSorted = true;
            // 逆向冒泡，大的往下沉
            for (int j = low; j < high; j++) {
                if (less(nums[j + 1], nums[j])) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
            high--;
            // 正向冒泡，小的往上浮
            for (int j = high; j > low; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                    isSorted = false;
                }
            }
            low++;
        }
    }

    public static void main(String[] args) {
        BubbleSort2<Integer> sortInt = new BubbleSort2<>();
        Integer a[] = {4, 9, 1, 2, 5, 8, 7, 6};
        sortInt.sort(a);
        System.out.println("最终结果：");
        sortInt.display(a);

        BubbleSort2<Double> sortDouble = new BubbleSort2<>();
        Double b[] = {2.2, 58.3, 6.0, 56.1, 5.1, 93.63};
        sortDouble.sort(b);
        System.out.println("最终结果：");
        sortDouble.display(b);

        BubbleSort2<String> sortStr = new BubbleSort2<>();
        String s[] = {"d", "f", "D", "r", "U"};
        sortStr.sort(s);
        System.out.println("最终结果：");
        sortStr.display(s);
    }
}
