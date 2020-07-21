package day02;

//定义了一个长度为39的数组，求出第20大的数
public class Example5_8 {
    public static void main(String[] args) {
        int arr[]={5,6,12,45,1,65,48,62,46,51,2,63,8,32,56,48,96,12,56,48,23,56,49,56,25,15,16,46,16,49,26,46,25,67,84,82,91,73,56};
        int num;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<arr[i+1]){
                num=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=num;
                System.out.println(arr[i]);
            }
           // System.out.println(arr[i]);
        }
//        Arrays.sort(arr);//Arrays是util包
//
//        for(int i : arr){
//
//            System.out.println(i);
//
//        }
        for(int i:arr){

            System.out.println(i);

        }
    }

}

