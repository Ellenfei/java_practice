package practice;

/**
 * Created by ye on 2016/11/23.
 */

enum Gender {
    MALE,FEMALE;
    private String name;
    public void setName (String name) {
        switch (this)
        {
            case MALE:
                if (name.equals("man"))
                {
                    this.name = name;
                }
                else
                {
                    System.out.println("参数错误。");
                }
                break;
            case FEMALE:
                if (name.equals("woman"))
                {
                    this.name = name;
                }
                else
                {
                    System.out.println("参数错误。");
                }
                break;
        }
    }
    public String getName (){
        return this.name;
    }
}

public class GenderTest {
    public static void main(String[] args) {
        Gender g = Gender.valueOf("FEMALE");
        g.setName("woman");
        System.out.print(g + "代表：" + g.getName());
    }
}
