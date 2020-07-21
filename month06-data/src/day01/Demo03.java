package day01;

public class Demo03 {
    public static void main(String[] args) {
        //遍历数组的所有方法
        int [] arr=new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+100;
        }
        System.out.println("==============");
        int i=0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }

        int []arr1;
        arr1=arr.clone();//数组的复制
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr1[j]);
        }
        /*
        * src:       原数组  arr1
        * srcPos：   原数组从第几个元素开始赋值   0  position 位置
        * dest       目的数组arr2
        * destPos：   复制到目的数组的第几个元素3
        * length:    复制的元素个数3
        * */
        System.arraycopy(arr,0,arr1,3,3);

    }
}
