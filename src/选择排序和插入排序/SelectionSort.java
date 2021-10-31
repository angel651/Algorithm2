package 选择排序和插入排序;

/**
 * 描述     TODO
 *
 * @author lixinzhen
 * @create 2021/9/27 10:57
 */
//总是把还没处理的最小的那个元素拿出来(从小到大)，可以进行原地排序
public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //arr[0..i)是有序的，arr[i..n)是无序的
        for (int i = 0; i < arr.length; i++) {
            //选择arr[i..n]中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {//返回一个整数(可比较)
                    minIndex = j;
                }
            }
            Swap(arr, i, minIndex);
        }
    }

    private static <E> void Swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr={1,4,2,3,6,5};
        SelectionSort.sort(arr);
        for (int e:arr)
            System.out.print(e+" ");
        System.out.println();
//        Student[] students={new Student("Alice",98),new Student("Bobo",100),new Student("Charles",66)};
//        SelectionSort.sort(students);
//        for (Student student:students){
//            System.out.print(student+" ");
//        }
//        System.out.println();
    }
}
