package cn.java.day03;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
    public void main(String[] args) throws IOException {

        File dir=new File("D:\\app\\MySQL");
        String[] filenames = dir.list();
        File[] files = dir.listFiles();

        System.out.println("=================");

        for (String filename : filenames) {
            System.out.println(filename);
        }
        System.out.println("====================");
        for (File file : files) {

            System.out.println(file);
        }


        System.out.println("============txt============");
        FilenameFilter txtFilter = new txtFilenameFilter();
        String[] txtFilters =dir.list(txtFilter);
        dir.list(txtFilter);
        for (String filename : txtFilters) {
            System.out.println(filename);
        }
    }
    static class Mp4FilenameFilter implements FilenameFilter{
        public boolean accept(File dir,String name){
            boolean ret=name.endsWith("mp4");
            return ret;
        }
    }
    public void File (){
        File file = new File("d:/app");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.length());
        //System.out.println(file.lastModified());
        //练习，将改文件的最后修改时间显示在控制台
        Date date=new Date(file.lastModified());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

    }

    public static class txtFilenameFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            return false;
        }
    }
}
