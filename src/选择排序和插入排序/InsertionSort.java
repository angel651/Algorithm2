package 选择排序和插入排序;


/**
 * 描述     TODO
 *
 * @author lixinzhen
 * @create 2021/9/28 14:34
 */
//与选择排序的区别在于前面排序的对象是暂时稳定的排序
    //对于有序数组，插入排序的复杂度是O(n)，整体的复杂度是O(n^2)，而选择排序是稳定的排序算法，O(n^2)
public class InsertionSort {
    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适位置
            E t = arr[i];
            int j;//实际存储的位置
            for (j = i;j - 1 >0 && t.compareTo(arr[j-1])<0;j--){
                arr[j] = arr[j-1];//前面的元素向后平移
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        InsertionSort.sort(arr);
        for (int e : arr)
            System.out.print(e + " ");
        System.out.println();
    }
}
