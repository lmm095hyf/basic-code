package day20_2;

public class 圆 implements 平面图形,周长{


    @Override
    public double 面积(int r) {
        return 3.14*r*r;
    }

    @Override
    public double 周长(int r) {
        return 3.14*r*2;
    }

}
