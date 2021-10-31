package 归并排序法;

import java.util.Arrays;

/**
 * 描述     归并排序算法
 *
 * @author lixinzhen
 * @create 2021/9/28 18:10
 */
public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    //合并两个有序区间， arr[l..mid]和arr[mid+1..r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);//前闭后开
        int i = l, j = mid + 1;
        //每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - 1];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
