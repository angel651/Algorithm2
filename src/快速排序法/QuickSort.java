package 快速排序法;

import java.util.Arrays;
//每次从当前考虑的数组中选择一个元素，以这个元素为基点，之后将这个元素挪到排好序的时候应该在的位置
//这样就有一个性质，这个元素之前的所有元素小于它，之后的所有元素大于它。然后分别对这两边进行快速排序，逐渐递归下去，完成整个排序过程。
/**
 * 描述     TODO
 *
 * @author lixinzhen
 * @create 2021/9/30 10:10
 */
public class QuickSort {
    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        //arr[l+1..j] < v ; arr[j+1..i] > v
        int j = l;//标定点所在位置
        for (int i = l + 1; i <= r; i++)
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                Swap(arr, i, j);
            }
        Swap(arr, l, j);
        return j;//返回标定点所在位置的索引
    }

    private static <E extends Comparable<E>> void Swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 6, 2, 3, 1, 5, 7, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
