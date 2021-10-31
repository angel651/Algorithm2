package 堆和优先队列;

/**
 * 描述     优先队列
 *
 * @author lixinzhen
 * @create 2021/10/31 17:32
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);//入队
    E dequeue();//出队
    E getFront();
}
