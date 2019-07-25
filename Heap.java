package com.wuyi.notecode.sort;

public class Heap {
    public int[] nums;
    public int count;//堆中元素个数
    public int size;//堆的大小

    public Heap(int size ) {
        this.size = size;
        count = 0;
        nums = new int[size];
    }

    //获取父节点
    public int Parent(int i) {
        if(i <= 0 || i > this.count)
            return -1;
        return( i - 1 ) / 2;
    }

    //获取左孩子
    public int LeftChild(int i) {
        int l = 2 * i +1;
        if(l <= 0 || l > this.count - 1)
            return -1;
        return l;
    }

    //获取右孩子
    public int RightChild(int i) {
        int r = 2 * i +2;
        if(r <= 0 || r > this.count - 1)
            return -1;
        return r;
    }

    //获取最大值
    public int GetMax() {
        if(this.count == 0)
            return -1;
        return this.nums[0];
    }

    //堆化元素,向下渗透
    public void PrecolateDown(int k) {
        //非递归实现
        while (2 * k < count) {
            int j = 2 * k + 1;
            if (j < count - 1 && nums[j] < nums[j + 1])
                j++;
            if (j > count - 1 || nums[k] >= nums[j])
                break;
            swap(nums, j, k);
            k = j;
        }
    }

    private void swap(int[] nums, int j, int k) {
        int temp = this.nums[j];
        this.nums[j] = this.nums[k];
        this.nums[k] = temp;
    }

    //删除元素,时间复杂度O（logn）
    public int remove() {
        if(count == 0)
            return -1;
        int temp = nums[0];
        nums[0] = nums[--count];
        PrecolateDown(0);
        return temp;
    }

    //插入元素,时间复杂度O（logn）
    public void insert(int data) {
        if(count == 0) {
            nums[0] = data;
            return;
        }

        if(count == size) {
            ReSizeHeap();
        }
        count++;
        int i = count - 1;
        while(i > 0 && data > nums[( i - 1) / 2]) {
            nums[i] = nums[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        nums[i] = data;
    }

    private void ReSizeHeap() {
        int[] newA = new int[size * 2];
        System.arraycopy(nums, 0, newA, 0, size);
        size = size * 2;
        nums = newA;
        newA = null;
    }

    //清空堆
    public void DestroyHeap() {
        count = 0;
        nums = null;
    }

    //数组建堆
    void BuildHeap(int a[] , int n) {
        if(size == 0)
            return;
        while( n > size) {
            ReSizeHeap();
        }
        for(int i = 0 ; i < n ; i++)
            this.nums[i] = a[i];
        count = n;
        for(int i = count / 2 ; i >= 0 ; i--) {
            PrecolateDown(i);
        }
    }

    //打印堆元素
    public void display() {
        for(int i = 0 ; i < count; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {12,2,3,4,11,6,7,8};
        Heap heap = new Heap(a.length);
        heap.BuildHeap(a, a.length);
        heap.display();
        heap.insert(15);
        heap.display();
        heap.remove();
        heap.display();
        heap.DestroyHeap();
        heap.display();
    }
}

