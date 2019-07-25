    package com.wuyi.notecode.sort;

    public abstract class Sort<T extends Comparable<T>>{

        public abstract void sort(T[] nums);

        protected boolean less(T v, T w){
            return v.compareTo(w) < 0;
        }

        protected void swap(T[] nums, int i, int j){
            if (i == j)
                return;

            T temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        protected void display(T[] nums){
            for (T a : nums){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
