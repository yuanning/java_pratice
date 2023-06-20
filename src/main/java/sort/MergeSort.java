package sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
//        merge(array, start, mid, end);
        mergeNew(array, start, mid, end);
    }

    /**
     * by 不会写代码的阿婧
     * @param array 数组
     * @param start 第一部分起始位置
     * @param mid 两个数组中间位置
     * @param end 结束位置
     * mid中位数将原数组分为两部分，命名为数组一和数组二
     * 先将数组一放入临时数组，然后将数组二与临时数组进行元素比较(双指针操作)  将相对较小的数字放入原数组中
     */
    public void mergeNew(int[] array, int start, int mid, int end) {
        int tempSize = mid + 1 - start;
        //临时数组
        int[] temp = new int[tempSize];
        System.arraycopy(array, start, temp, 0, tempSize);

        int p1 = 0;
        int p2 = mid + 1;
        for (int i = start; i <= end; i++) {
            if (temp[p1] <= array[p2]) {
                array[i] = temp[p1];
                p1++;
                //如果左侧指针先到达临界位置  说明右侧数组当前指针指向的值 均大于左侧数组值
                if (p1 == tempSize) {
                    break;
                }
            } else {
                array[i] = array[p2];
                p2++;
                //如果右侧指针先到达临界位置  说明右侧数组均小于左侧数组当前指针指向的值  在左侧数组未填充完的情况下，需把左侧数组剩余元素补充在数组后面
                if (p2 > end) {
                    while (p1 < tempSize) {
                        i++;
                        array[i] = temp[p1];
                        p1++;
                    }
                }
            }
        }
    }

    /**
     * 常规方式 generate by ChatGpt
     * @param array
     * @param start
     * @param mid
     * @param end
     * 先将比对后相对较小的数据放入临时数组，最后统一将临时数组的数据放入原数组中
     */
    public void merge(int[] array, int start, int mid, int end) {
        //临时数组
        int[] temp = new int[array.length];
        int p = start;
        int q = mid + 1;
        //临时数组size
        int index = 0;
        while (p <= mid && q <= end) {
            if (array[p] > array[q]) {
                temp[index++] = array[q++];
            } else {
                temp[index++] = array[p++];
            }
        }
        while (p <= mid) {
            temp[index++] = array[p++];
        }
        while (q <= end) {
            temp[index++] = array[q++];
        }
        System.arraycopy(temp, 0, array, start, index);
    }

    public static void main(String[] args) {
        int[] array = {16,7,13,10,9,15,3,2,5,8,12,1,11,4,6,14};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
