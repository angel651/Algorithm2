package 二分查找法;

/**
 * 描述     二分查找法
 * 对于有序数列，才能使用二分查找法,二分查找法的时间复杂度是O(log n)
 *
 * @author lixinzhen
 * @create 2021/10/21 11:19
 */
public class BinarySearch {
    private BinarySearch(){}

    /**
     * 非递归实现二分查找法
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int search (E[] data,E target){
        int l =0,r = data.length -1 ;
        //在data[l,r]的范围中查找target
        while (l <= r){
            int mid = l + (r - l)/2;
            if (data[mid].compareTo(target) == 0){
                return mid;
            }
            if (data[mid].compareTo(target) < 0){
                l = mid + 1;
            }
            else r = mid -1;
        }
        return -1;
    }

    /**
     * 递归法实现二分查找法
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int searchR (E[] data,E target){
        return searchR(data,0,data.length-1,target);
    }
    public static <E extends Comparable<E>> int searchR (E[] data,int l,int r,E target){
        if (l > r) return -1;
        int mid = l + (r - l)/2;
        if (data[mid].compareTo(target) == 0){
            return mid;
        }
        if (data[mid].compareTo(target) < 0){
            return searchR(data,mid+1,r,target);
        }
        return searchR(data,l,mid - 1,target);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(search(arr,4));//3
        System.out.println(searchR(arr,4));//3
    }
}
