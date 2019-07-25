package com.wuyi.notecode.sort;

public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = binarySearch(nums, 0, i, nums[i]);
            T value = nums[i];
            for (int k = i; k > j; k--){
                nums[k] = nums[k-1];
            }
            nums[j] = value;
        }
    }

    private int binarySearch(T[] nums, int low, int high, T target) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (less(nums[mid], target)) {
                low = mid + 1;

            } else {
                high = mid - 1;

            }
        }
        return low;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ShellSort<Integer> sortInt1 = new ShellSort<>();
        for (int i = 0; i < 100000; i++) {
            Integer a[] = {4, 92, 13, 2, 6, 2, 10, 16, 3, 8, 5, 1};
            sortInt1.sort(a);
            if (i == 9999){
                System.out.println("最终结果：");
                sortInt1.display(a);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("ShellSort 运行时间：" + (end - start) + "毫秒");

        long start2 = System.currentTimeMillis();
        InsertionSort2<Integer> sortInt2 = new InsertionSort2<>();
        for (int i = 0; i < 100000; i++) {
            Integer a[] = {4, 92, 13, 2, 6, 2, 10, 16, 3, 8, 5, 1};
            sortInt2.sort(a);
            if (i == 9999){
                 System.out.println("最终结果：");
                 sortInt2.display(a);
            }

        }
        long end2 = System.currentTimeMillis();
        System.out.println("InsertionSort2 运行时间：" + (end2 - start2) + "毫秒");




//        InsertionSort2<Double> sortDouble = new InsertionSort2<>();
//        Double b[] = {2.2, 58.3, 6.0, 56.1, 5.1, 93.63};
//        sortDouble.sort(b);
//        System.out.println("最终结果：");
//        sortDouble.display(b);
//
//        InsertionSort2<String> sortStr = new InsertionSort2<>();
//        String s[] = {"d", "f", "D", "r", "U"};
//        sortStr.sort(s);
//        System.out.println("最终结果：");
//        sortStr.display(s);
    }
}
