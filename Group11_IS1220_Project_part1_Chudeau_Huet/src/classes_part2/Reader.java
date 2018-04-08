package classes_part2;

import java.util.ArrayList;
import java.util.Scanner;

import classes_part1.User;
import classes_part1.VelibPark;

public class Reader {
	
	static ArrayList<VelibPark> parks = new ArrayList<VelibPark>();
	static ArrayList<User> users = new ArrayList<User>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String string = "";
		Interpreter interpreter = new Interpreter();
		
		System.out.println("Welcome to the MyVelib interface");
		System.out.println("If you need any help, please type help");
		
		while (!string.equalsIgnoreCase("exit")) {
			string = scanner.nextLine();
			interpreter.InterpretCommand(string);
		}
		scanner.close();
		parks = new ArrayList<VelibPark>();
	}

}
