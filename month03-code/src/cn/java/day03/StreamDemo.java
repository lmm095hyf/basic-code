package cn.java.day03;

import java.io.*;
import  java.io.FileWriter;//这个已经在上面那里了
//你的FileWrite包下面怎么可能有read这个方法


public class StreamDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader("d:/app");
            char[] buffer = new char[1024];
            int count;
            do {
                count = fr.read(buffer);
                if (count != -1) {
                    String txt = new String(buffer, 0, count);
                    System.out.println(txt);
                }
            } while (count != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void write() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("d:/app");
            fw.write("定义 文件输出字符流");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fw!=null){
                try{
                    fw.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}