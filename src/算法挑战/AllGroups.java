package 算法挑战;

import java.util.*;

public class AllGroups {

    public static List<String> set = new ArrayList<>();


    public static void doSet(String start, String[] sourceList, int max) {
        String[] olds = start.split("_");
        if (olds.length == max) {
            set.add(start.replaceAll("_", "").trim());
        }
        else {
            for (int s = 0; s < sourceList.length; s++) {
                if (Arrays.asList(olds).contains(sourceList[s])) {
                    continue;
                }
                else {
                    doSet(start + "_" + sourceList[s], sourceList, max);
                }
            }
        }
    }

    public static void doSet(String[] sourceList, int max) {
        for (int start = 0; start < sourceList.length; start++) {
            doSet(sourceList[start], sourceList, max);
        }

    }

    public static void print() {
        System.out.println("Total:" + set.size());
        int cols = 10;
        for (String s : set) {
            System.out.print(s + " ");
            if (cols-- == 1) {
                System.out.println();
                cols = 10;
            }
        }
        set.clear();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] haha = new String[] { "1", "2", "1" };
        System.out.println();
        System.out.println(" ************" + " 1 " + " **************** ");
        doSet(haha, 1);
        print();
        System.out.println();
        System.out.println(" ************" + " 2 " + " **************** ");
        doSet(haha, 2);
        print();
        System.out.println();
        System.out.println(" ************" + " 3 " + " **************** ");
        doSet(haha, 3);
        print();
//        System.out.println();
//        System.out.println(" ************" + " 4 " + " **************** ");
//        doSet(haha, 4);
//        print();
//        System.out.println();
//        System.out.println(" ************" + " 5 " + " **************** ");
//        doSet(haha, 5);
//        print();
    }

}