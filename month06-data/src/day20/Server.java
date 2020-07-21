package day20;

import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args)throws Exception{
		ServerSocket svsk=new ServerSocket(1002);
		while(true) {
			Socket s=svsk.accept();
			ServerThread t=new ServerThread(s);
			t.start();
		}
	}
}
class ServerThread extends Thread{
	Socket sk;
	ServerThread(Socket s){
		sk=s;
	}
	public void run() {
		try {
			InputStream in=sk.getInputStream();
			OutputStream out=sk.getOutputStream();
			InputStreamReader rin=new InputStreamReader(in);
			OutputStreamWriter wout=new OutputStreamWriter(out);
			BufferedReader br=new BufferedReader(rin);
			BufferedWriter pw=new BufferedWriter(wout);
			String s =br.readLine();
			pw.write(s+"你好!");
			pw.newLine();
			pw.flush();
			in.close();
			out.close();
			sk.close();
		}
		catch(IOException e) {}
	}
}
