package 算法挑战;

/**
 * 描述     TODO
 *
 * @author lixinzhen
 * @create 2021/11/6 15:44
 */
import java.util.HashSet;
import java.util.Scanner;

public class String1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符串:");
        String s = sc.next();
        char[] c = s.toCharArray();//将字符串转为字符数组
        HashSet set = new HashSet();
        StringBuilder sbd = new StringBuilder();
        //遍历字符数组
        for (int i = 0; i < c.length; i++) {
            //利用HashSet的add()方法,他返回的是一个布尔值,添加成功会返回true
            if (set.add(c[i])){
                sbd.append(c[i]);
            }
        }
        System.out.println(sbd);
    }
}

