package com.wuyi.notecode.sort;

import java.util.Random;

public class Main<T extends Comparable<T>> {

    public long testSort(Sort<Integer> sort) {
        Integer[] nums = new Integer[1000000];
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            nums[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();
        sort.sort(nums);
        long end = System.currentTimeMillis();

        return end - start;
    }


    public static void main(String[] args) {
        Main<Integer> main = new Main<>();
        BubbleSort1<Integer> bubbleSort1 = new BubbleSort1<>();

//        long res = main.testSort(bubbleSort1);
//        System.out.println("BubbleSort1 运行时间:" + res + "毫秒");
//
//
//        BubbleSort2<Integer> bubbleSort2 = new BubbleSort2<>();
//        res = main.testSort(bubbleSort2);
//        System.out.println("BubbleSort2 运行时间:" + res + "毫秒");
//
//
//        SelectionSort1<Integer> selectionSort1 = new SelectionSort1<>();
//        res = main.testSort(selectionSort1);
//        System.out.println("SelectionSort1 运行时间:" + res + "毫秒");
//
//
//        SelectionSort2<Integer> selectionSort2 = new SelectionSort2<>();
//        res = main.testSort(selectionSort2);
//        System.out.println("SelectionSort2 运行时间:" + res + "毫秒");
//
//
//        InsertionSort1<Integer> insertionSort1 = new InsertionSort1<>();
//        res = main.testSort(insertionSort1);
//        System.out.println("InsertionSort1 运行时间:" + res + "毫秒");
//
//
//        InsertionSort2<Integer> insertionSort2 = new InsertionSort2<>();
//        res = main.testSort(insertionSort2);
//        System.out.println("InsertionSort2 运行时间:" + res + "毫秒");


        ShellSort<Integer> shellSort = new ShellSort<>();
        long res = main.testSort(shellSort);
        System.out.println("ShellSort 运行时间:" + res + "毫秒");


        HeapSort<Integer> heapSort = new HeapSort<>();
        res = main.testSort(heapSort);
        System.out.println("HeapSort 运行时间:" + res + "毫秒");


        MergeSort<Integer> mergeSort = new MergeSort<>();
        res = main.testSort(mergeSort);
        System.out.println("MergeSort 运行时间:" + res + "毫秒");


        QuickSort<Integer> quickSort = new QuickSort<>();
        res = main.testSort(quickSort);
        System.out.println("QuickSort 运行时间:" + res + "毫秒");


        ThreeWayQuickSort<Integer> threeWayQuickSort = new ThreeWayQuickSort<>();
        res = main.testSort(threeWayQuickSort);
        System.out.println("ThreeWayQuickSort 运行时间:" + res + "毫秒");

    }
}
