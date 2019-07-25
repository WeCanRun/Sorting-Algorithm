package com.wuyi.notecode.sort;

public class SelectionSort2<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N / 2; i++) {
            int min = i, max = N - 1 - i;
            for (int j = i + 1; j <= N - 1 - i; j++) {
                if (less(nums[j], nums[min]))
                    min = j;
                else if (less(nums[max], nums[j]))
                    max = j;
            }
            swap(nums, i, min);
            // 避免两次交换
            if (max == i)
                continue;
            swap(nums, N - 1 - i, max);
        }
    }

    public static void main(String[] args) {
        SelectionSort2<Integer> sortInt = new SelectionSort2<>();
        Integer a[] = {4, 9, 1, 2, 5, 8, 7, 6};
        sortInt.sort(a);
        System.out.println("最终结果：");
        sortInt.display(a);

        SelectionSort2<Double> sortDouble = new SelectionSort2<>();
        Double b[] = {2.2, 58.3, 6.0, 56.1, 5.1, 93.63};
        sortDouble.sort(b);
        System.out.println("最终结果：");
        sortDouble.display(b);

        SelectionSort2<String> sortStr = new SelectionSort2<>();
        String s[] = {"d", "f", "D", "r", "U"};
        sortStr.sort(s);
        System.out.println("最终结果：");
        sortStr.display(s);
    }
}
