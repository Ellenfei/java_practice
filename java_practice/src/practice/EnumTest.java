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
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎");
                break;
            case FALL:
                System.out.println("秋高气爽");
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
