package 算法挑战;

import java.util.*;

/**
 * 描述     算法挑战
 *
 * 给出一个升序排序的可能重复值的数字数组和一个目标值，
 * 其中目标值大于数组中最小数，
 * 求数组中数字组合（可多值组合）相加最接近目标数的组合（可能多个）；
 * 不考虑空间复杂度，效率最优的算法;
 * 样例：
 * 数组为[3，4，8]，目标值为9，最接近组合为【8】
 * 数组为[2,30,42,67]，目标值50，最接近组合为[2,42]
 * @author lixinzhen
 * @create 2021/11/4 10:20
 */
public class Challenge1 {
        public static void main(String[] args) {
            List<Integer> integers = new ArrayList<>();
            integers.add(new Integer(3));
            integers.add(new Integer(6));
            integers.add(new Integer(7));
            integers.add(new Integer(15));
            integers.add(new Integer(24));
            List<List<Integer>> arr = getArr(integers);
            List<List<Integer>> back = back(arr, 29);
            for (int i = 0; i < back.size(); i++) {
                List<Integer> l1 = back.get(i);
                for (int i1 = 0; i1 < l1.size(); i1++) {
                    System.out.print(l1.get(i1)+"  ");
                }
                System.out.println();
            }
        }

        public static List<List<Integer>> back(List<List<Integer>> list,Integer x){
            Map<Integer, List<Integer>> map = new HashMap<>();
            Map<Integer, List<Integer>> maps = new HashMap<>();
            List<List<Integer>> lists = new ArrayList<>();

            ArrayList<Integer> objects = new ArrayList<>();
            Integer sum=new Integer(0);
            for (int i = 0; i < list.size(); i++) {
                List<Integer> integers = list.get(i);
                for (int i1 = 0; i1 < integers.size(); i1++) {
                    sum+=integers.get(i1);
                    objects.add(Math.abs(sum-x));
                }
                sum=0;
            }
            Integer min = Collections.min(objects);
            for (int i = 0; i < list.size(); i++) {
                List<Integer> integers = list.get(i);
                for (int i1 = 0; i1 < integers.size(); i1++) {
                    sum+=integers.get(i1);
                }
                if(min==Math.abs(sum-x)){
                    lists.add(integers);
                }
                sum=0;
            }
            return lists;
        }

        public static List<List<Integer>> getArr(List<Integer> list) {
            List<List<Integer>> result = new ArrayList<>();
            long n = (long) Math.pow(2, list.size());
            List<Integer> temp;
            for (long l = 0L; l < n; l++) {
                temp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if ((l >>> i & 1) != 1) {
                        temp.add(list.get(i));
                    }
                }
                if (!temp.isEmpty()) result.add(temp);
            }
            return result;
        }
}
