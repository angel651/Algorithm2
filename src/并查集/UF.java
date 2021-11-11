package 并查集;

/**
 * 描述     并查集
 *
 * @author lixinzhen
 * @create 2021/11/10 20:36
 */
//网络中节点间的连接状态
//网络是个抽象的概念：用户之间形成的网络
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
