package 线性查找法;

/**
 * @author boyas
 * @create 2021/8/8 23:23
 */
public class LinearSearch {
    //禁止用户new一个LinearSearch对象
    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(target))//对象比较用equals
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGennerator.generateOrderedArray(n);
            long startTime = System.nanoTime();
            LinearSearch.search(data, n);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n =" + n +" , "+ time + "s");
        }
//        System.out.println(res);
//        Student[] students={new Student("Alice"),new Student("Bobo"),new Student("Charles")};
//        Student bobo = new Student("Bobo");
//        int res1=LinearSearch.search(students,bobo);
//        System.out.println(res1);
    }
}
