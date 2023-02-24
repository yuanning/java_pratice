package sort;

import java.util.Arrays;

/**
 * 快速排序 (from 漫画算法 程序员小灰)
 */
public class QuickSort {

    /**
     * 快速排序  双边循环法
     */
    private static void quickSort(int[] arr, int beginIndex, int endIndex) {
        if (arr.length == 0 || beginIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arr, beginIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort(arr, beginIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 基于数据进行分区  分治法（双边循环法）
     * @param arr  待交换的数组
     * @param beginIndex  起始下标
     * @param endIndex   截止下标
     * @return
     */
    private static int partition(int[] arr, int beginIndex, int endIndex) {
        //默认取第一个元素作为基准点
        int pivot = arr[beginIndex];
        int left = beginIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left与right指针所指向的元素
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        //pivot和指针重合点交换
        arr[beginIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     * 分治法 (单边循环法)
     * @param arr
     * @param beginIndex
     * @param endIndex
     * @return
     */
    private static int partitionV2(int[] arr, int beginIndex, int endIndex) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,5,4,9,6,1,0,5,7};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
