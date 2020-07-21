package day20_2;

public class 正方形 implements 平面图形,周长{

    @Override
    public double 面积(int r) {
        return r*r;
    }

    @Override
    public double 周长(int r) {
        return 4*r;
    }

}