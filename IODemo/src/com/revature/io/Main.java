package com.revature.io;

import java.io.*;

import com.revature.bean.Person;

public class Main {

	public static void main(String[] args) throws IOException {
		/*BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new FileReader("src/new.txt"));
			out = new PrintWriter(new FileWriter("src/out.txt"));
			
			String c;
			while((c = in.readLine()) != null) {
				out.println(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}*/
		
		Person p = new Person("Nora", 22, 123456);
		Person p2 = new Person("Caleb", 21, 123456);
		writeObject("src/Person", p, p2);	
		readObject("src/Person");
		
	}
	
	static void writeObject(String filename, Object obj, Object obj2) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(obj);
			oos.writeObject(obj2);
			System.out.println(obj);
			System.out.println(obj2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Person p = (Person) ois.readObject();
			Person p2 = (Person) ois.readObject();
			System.out.println(p);
			System.out.println(p2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//1) Write a program to display the first 25 Fibonacci numbers beginning at 0.
	//2) Write a program to compute N factorial.

}















