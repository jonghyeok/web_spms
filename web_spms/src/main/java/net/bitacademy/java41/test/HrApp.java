package net.bitacademy.java41.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HrApp {

	static class AccAppStub{
		public int getSalary(String name)throws Exception{
			Socket socket = new Socket("localhost",8989);
			PrintStream out = new PrintStream(socket.getOutputStream());
			Scanner in = new Scanner(socket.getInputStream());
			
			out.print(name);
			int salary = Integer.parseInt(in.nextLine());
			
			out.close();
			in.close();
			socket.close();
			return salary;
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		AccAppStub stub = new AccAppStub();
		System.out.println(stub.getSalary("홍길동"));
		System.out.println(stub.getSalary("임꺽정"));
		
		
	}
}
