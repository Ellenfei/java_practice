package practice;

/**
 * Created by ye on 2016/10/18.
 */
 enum SeasonEnum{
    SPRING,SUMMER,FALL,WINTER;
}
public class EnumTest {
    public void Test(SeasonEnum s){
        switch (s)
        {
            case SPRING:
                System.out.println("��ů����");
                break;
            case SUMMER:
                System.out.println("��������");
                break;
            case FALL:
                System.out.println("�����ˬ");
                break;
            default:
                System.out.println("....");
        }
    }

    public static void main(String args[]){
        EnumTest e = new EnumTest();
        e.Test(SeasonEnum.SPRING);

        for (SeasonEnum s : SeasonEnum.values()){
            System.out.println(s);
        }
    }
}
