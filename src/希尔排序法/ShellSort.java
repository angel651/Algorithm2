package 希尔排序法;

/**
 * 描述     希尔排序法
 *
 * @author lixinzhen
 * @create 2021/11/1 19:28
 */
public class ShellSort {
    private ShellSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;
        //只要大于等于1，就会分成多个子数组
        while (h >= 1) {
            //start是每一个子数组起始元素位置相应的索引
            for (int start = 0; start < h; start++) {
                //对data[start,start+h,start+2h,start+3h....]，进行插入排序
                for (int i = start + h; i < data.length; i += h) {
                    E t = data[i];//当前要插入的元素t
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];//往后挪移一个位置
                    }
                    data[j] = t;//插入元素
                }
            }
            h /= 2;
        }
    }
}
