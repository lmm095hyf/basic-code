package cn.java.day12;
import cn.java.day05.IOHelper;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/*
 * 1.案例练习：模拟cmd程序
 * 2.API+Util 30个题，讲题
 * */

public class Cmd {
    /**
     * dir查询文件
     * cd 切换目录
     * copy复制文件
     * type查看文件内容
     *   .  当前文件夹
     *   ..  上一级文件夹
     *   cd.. 返回上一次文件夹
     *
     * rename重命名
     * del删除
     * */
    private String prompt="C:\\Users\\Administrator.USER-20181009ZD";//当前路径
    private Scanner scanner=new Scanner(System.in);

     public void start(){
         System.out.println("Microsoft Windows [版本 10.0.18363.657]");
         System.out.println("(c) 2019 Microsoft Corporation。保留所有权利。");
         System.out.println();
         while(true){
             System.out.print(prompt+">");
             String cmdline = scanner.nextLine();//读取一行文字
             /*String cmd;
            //找空格
             int index=cmdline.indexOf(" ");

             if(index==-1){
                 cmd=cmdline;
             }else{
                 cmd=cmdline.substring(0,index);
             }*/
             String [] cmds=cmdline.split(" ");
             //cmd==null，此时会报出空指针异常

             if("dir" .equals(cmds[0])){
                 dir();
             }else if("cd".equals(cmds[0])){
                 String argrument=cmds.length==1?null:cmds[1];
                 cd(argrument);
             }else if("copy".equals(cmds[0])){
                 copy(cmds[1],cmds[2]);
             }
         }
     }
     public void copy(String srcFilename,String destFilename){
         File srcFile=new File(prompt,srcFilename);
         File destFile=new File(prompt,destFilename);
         FileInputStream fis=null;
         FileOutputStream fos=null;
         try{
             fis=new FileInputStream(srcFile);
             fos=new FileOutputStream(destFile);
             byte [] buffer=new byte[1024];
             int count;
             while(     (count =fis.read(buffer))!=-1     ){
                 fos.write(buffer,0,count);
             }
             System.out.printf("已复制%15s个文件\n",1);
         } catch (IOException e) {
             System.out.println("文件复制失败！");
         } finally {
             IOHelper.close(fis);
             IOHelper.close(fos);
         }
     }
     public void cd(String path){

         if ("..".equals(path)) {
             File f=new File(prompt);
             prompt=f.getParent();
         }else{
             File f=new File(prompt,path);
             if(f.exists()){
                 prompt=f.getAbsolutePath();
             }else{
                 System.out.println("系统找不到指定路径.");
             }
         }

     }
     public void dir(){
         File f=new File(prompt);
         File[] flies=f.listFiles();
         int fileNumber=0;
         int dirNumber=0;
         long fileSize=0;
         for(File file:flies){
             if(file.isHidden()){
                 continue;
             }
             long time=file.lastModified();//修改日期的时间戳
             Date date=new Date(time);
             String mask="yyyy/MM/dd/E HH:mm";//年月日星期 时间点
             SimpleDateFormat sdf=new SimpleDateFormat(mask);
             String datestr=sdf.format(date);

             String type=file.isDirectory()?"<DIR>":" ";//判断是否为文件

             String size=file.isFile()?""+file.length():"";//文件夹大小

             String filename=file.getName();

             System.out.printf("%s\t%s\t%s\t%s\t\n",datestr,type,size,filename);

             fileNumber+=file.isFile()?1:0;//记录文件数
             dirNumber+=file.isDirectory()?1:0;//记录目录数
             fileSize+=file.isFile()?file.length():0;//统计文件大小
         }
         System.out.printf("%15s个文件 %15s字节\n",fileNumber,fileSize);
         System.out.printf("%15s个目录 %15s可用字节\n",dirNumber,f.getFreeSpace());
         System.out.println();

     }

    public static void main(String[] args) {
        Cmd cmd=new Cmd();
        cmd.start();
    }
}
