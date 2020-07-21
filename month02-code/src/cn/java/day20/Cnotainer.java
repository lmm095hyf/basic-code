package cn.java.day20;

public class Cnotainer {
    //存放对象数组
    private Object[] objects=new Object[100];
    //存放对象在第几个元素上
    private int index;
    public IMeasurer measure;
    private double min;
    private double max;
    private Object minObject;
    private Object maxObject;

    public void addObject(Object obj){
        //请将对象存放到对象数组中
        if(index==100){
            System.out.println("容器已满！");
            return ;
        }
        if(obj ==null ){
            System.out.println("容器不能为空！");
            return ;
        }
        objects[index]=obj;
        //下标值+1
        index++;
    }
    public void setMeasurer(IMeasurer m){
        this.measure=m;
        //实现该方法
    }
    public void measure(){
         min=-1;
         max=-1;
         minObject =null;
         maxObject=null;

        //增强for循环
        for(Object obj:objects){
            //如果被测试对象为空，则测试结束
            if(obj==null){
                break;
            }
            double value=measure.measure(obj);
            if(min==-1||min>value){
                min=value;
                minObject=obj;

            }
            if(max==-1||max<value){
                max=value;
                maxObject=obj;
            }
        }

    }
    public Object getMax(){
        return max;
    }
    public Object getMin(){
        return min;
    }

    public Object getMinObject() {
        return minObject;
    }

    public Object getMaxObject() {
        return maxObject;
    }
}
