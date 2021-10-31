package 线性查找法;

/**
 * @author boyas
 * @create 2021/8/12 0:55
 */
public class ArrayGennerator {
    private ArrayGennerator() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
