package 堆和优先队列;

/**
 * 描述     堆排序
 *
 * @author lixinzhen
 * @create 2021/10/28 21:43
 */
public class HeapSort {
    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data) {
            maxHeap.add(e);
        }
        //升序排列
        for (int i = data.length - 1; i >= 0; i--)
            data[i] = maxHeap.extractMax();
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        if (data.length <= 1) {
            return;
        }
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
        for (int i = data.length - 1; i >= 0; i++) {
            swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    //对data[0,n)所形成的最大堆中，索引k的元素，执行siftDown
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;//在此轮循环中，data[k]和data[j]交换位置
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0)
                j++;
            //此时data[j]是leftChild和rightChild中的最大值
            if (data[k].compareTo(data[j]) >= 0)
                break;
            swap(data, k, j);
            k = j;
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 8, 0, 6, 5, 4, 2};
        HeapSort.sort(arr);
        for (int e : arr)
            System.out.print(e + " ");
    }
}
