package cn.java.day05;

import java.io.Closeable;
import java.io.IOException;

public class IOHelper {
    public static void close(Closeable c) {

        if(c!=null){
            try{
                c.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
