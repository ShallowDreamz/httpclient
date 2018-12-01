package com.TYServer.test;

public class MergeSort {
    public void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;//分解
            mergeSort(a, left, middle);//分解治理左半部分   -> 左半部分变有序

            mergeSort(a, middle + 1, right);//分解治理后半部分  -> 右半部分变有序

            merge(a, left, middle, right);//合并
        }
    }

    /**
     * 将数组 left 到 right 区间（将parent） 内进行排序，  使用 两个小数组 分别 区间为 left ，middle数组（简称A），middle+1，right（简称B），通过A，B数组得到parent的有效序列
     *
     * @param a
     * @param left
     * @param middle
     * @param right
     */
    private void merge(int[] a, int left, int middle, int right) {
        int[] tmpArray = new int[a.length];
        int rightStart = middle + 1;
        int tmp = left;
        int third = left;
        //比较两个小数组相应下标位置的数组大小，小的先放进新数组
        while (left <= middle && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                tmpArray[third++] = a [left++];
                /*tmpArray[third] = a[left];
                third++;
                left++;*/
            } else {
                tmpArray[third++] = a[rightStart++];

            }
        }
        //如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
        while (left <= middle) {
            tmpArray[third++] = a[left++];
        }
        //如果右边还有数据......
        while (rightStart <= right) {
            tmpArray[third++] = a[rightStart++];
        }
        while (tmp <= right) {
            a[tmp] = tmpArray[tmp++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{3, 1,5,2};
        mergeSort.mergeSort(a, 0, a.length - 1);
        for (int n : a) {
            System.out.print(" " + n);
        }
    }

}
