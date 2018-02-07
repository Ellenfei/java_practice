package jianzhi;

/**
 * Created by Ellen on 2017/12/7.
 *
 * 1.赋值运算符，自定义类实现
 */
class MyString {
    private String data;
    public MyString(String data) {
        this.data = data;
    }
    //赋值运算符
    public MyString assign (final MyString another) {
        if (this==another || this.data.equals(another.data)) {
            return this;
        } else {
            this.data = another.data;
            return this;
        }
    }
    //toString函数
    @Override
    public String toString() {
        return "MyString:"+"{"+this.data+"}";
    }
}
public class AssignOperation1 {
    public static void main(String[] args) {
        MyString s1 = new MyString("a");
        MyString s2 = new MyString("b");
        MyString s3 = new MyString("c");
        System.out.println(s1.assign(s2).assign(s3));
        System.out.println("s1:" + s1);
        System.out.println("s2:"+s2);
        System.out.println("s3:"+s3);
    }
}
