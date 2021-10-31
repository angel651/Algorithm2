package 线性查找法;

/**
 * @author boyas
 * @create 2021/8/10 0:16
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
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
}
