package 堆和优先队列;

/**
 * 描述     最大堆
 *
 * @author lixinzhen
 * @create 2021/10/26 22:29
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        //父亲节点比当前节点小，上浮
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);//最小的元素与堆顶元素交换
        data.removeLast();//删除最大的元素
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&//判断是否存在右孩子
                    data.get(j + 1).compareTo(data.get(j)) > 0)//判断右孩子是否大于左孩子
                j = rightChild(k);//相当于j++
            //此时data[j]是leftChild和rightChild中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0)//比较当前节点和左右孩子中的最大值的之间的大小
                break;
            //如果当前节点小于左右孩子中最大的那个，则交换位置
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中的最大元素，并且替换成元素e,时间复杂度O(logn)
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
    //heapify将任意数组整理成堆的形状,heapify的时间复杂度O(n)
    //对于n个节点的二叉树（有h层），如果是满二叉树。
    //最后一层(h)节点最多有2^(h-1)或n/2
    //非叶子节点2^(h-1)-1
    //叶子节点有2^(h-1)
    public  MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            siftDown(i);
        }
    }







}
