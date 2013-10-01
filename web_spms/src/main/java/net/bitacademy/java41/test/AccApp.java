package net.bitacademy.java41.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

class AccApp {

	HashMap<String, Integer> table = new HashMap<String,Integer>();

	public AccApp(){
		table.put("홍길동", 6000);
		table.put("임꺽정", 8000);
		table.put("일지매", 4000);
	}

	public int getSalary(String name){
		return table.get(name);
	}

	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(8989);
		PrintStream out = null;
		Scanner in = null;
		Socket socket = null;
		String name = null;
		int salary=0;
		AccApp table=null;
		while(true){
			ss.accept();
			socket = ss.accept();
			out = new PrintStream(socket.getOutputStream());
			in = new Scanner(socket.getInputStream());
			name = in.nextLine();
			salary = table.getSalary(name);

		}

	}



public class AccAppSkelton{
	
}
}