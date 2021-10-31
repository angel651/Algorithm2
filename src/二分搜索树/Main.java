package 二分搜索树;

import java.util.ArrayList;
import java.util.Random;

/**
 * 描述     TODO
 *
 * @author lixinzhen
 * @create 2021/10/22 21:03
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] nums = {5,3,6,8,4,2};
//        for (int num:nums)
//            bst.add(num);
//        bst.preOrder();
        Random random =  new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
    }
}
