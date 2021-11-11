package 并查集;

/**
 * 描述     第一版并查集
 * Quick Find下的Union时间复杂度是O(n)
 *
 * @author lixinzhen
 * @create 2021/11/10 21:01
 */
public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查找元素p所对应的集合编号
    private int find(int p) {
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound");
        return id[p];
    }

    //查看元素p和元素q是否所属一个集合(时间复杂度为O(1))
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合(时间复杂度为O(n))
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
    }
}
