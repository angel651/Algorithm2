package 线段树;

/**
 * 描述     融合器
 *
 * @author lixinzhen
 * @create 2021/11/2 7:57
 */
public interface Merger<E> {
    E merge(E a,E b);
}
