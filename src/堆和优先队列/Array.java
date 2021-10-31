package 堆和优先队列;

/**
 * 描述     TODO
 *
 * @author lixinzhen
 * @create 2021/10/26 22:31
 */
public class Array<E> {
    private int size;
    private E[] data;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    //无参的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //根据索引index取值
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal!");
        }

        return data[index];
    }

    //向所有元素后添加一个元素
    public void addLast(E e){
        if(size == data.length)
            throw new IllegalArgumentException("AddLast failed,Array is full");
        data[size] = e;
        size ++;
    }
    //获取数组中尾值
    public E getLast() {
        return get(size - 1);
    }

    //获取数组中首值
    public E getFirst() {
        return get(0);
    }

    //修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    //查找数组中元素是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public void add(int index, E e){
        if(size == data.length)
            //throw new IllegalArgumentException("AddLast failed,Array is full");
            resize(2*data.length);  // 动态数组能力

        if(index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed,index illegal");

        for (int i = size - 1; i >=index; i --)
            data[i+1] = data[i];  // 后移一位
        data[index] = e;
        size ++;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        E ret = data[index];
        for(int i = index+1; i < size; i ++)
            data[i-1] = data[i];
        size --;
        data[size] = null;  // loitering objects != memory leak

        if(size == data.length / 4 && data.length / 2 != 0)  // 防止复杂度震荡 使用lazy的方法 且防止缩为0
            resize(data.length / 2);  //动态数组
        return ret;  // return对应的是remove这个方法
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i ++)
            newData[i] = data[i];
        data = newData;
    }
}
