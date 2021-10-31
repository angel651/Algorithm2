package 选择排序和插入排序;

/**
 * @author boyas
 * @create 2021/8/10 0:16
 */
public class Student implements Comparable<Student>{
    private String name;
    private int score;

    public Student(String name,int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student)//判断传过来的对象是否与当前对象地址相等
            return true;
        if (student == null)//判断传过来的对象是否为空
            return false;
        if (this.getClass() != student.getClass())//判断类对象是否不等
            return false;
        Student another = (Student) student;
        return this.name.equals(another.name);//比较当前对象与目标对象的属性值是否相等
    }

    @Override
    public int compareTo(Student another) {
//        if (this.score < another.score)
//            return -1;
//        else if (this.score == another.score)
//            return 0;
//        return 1;
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
