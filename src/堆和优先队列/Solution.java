package 堆和优先队列;

/**
 * 描述     top问题
 *
 * @author lixinzhen
 * @create 2021/10/31 17:50
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.enqueue(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.getFront()) {
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.dequeue();
        }
        return res;
    }
}
