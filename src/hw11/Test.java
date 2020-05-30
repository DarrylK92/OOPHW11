/*
	This program allows the user to create a serialized Person object and store it in a bin file.
	The user can also read bin files that contain Person objects.
	Author: Darryl Karney
	Course: CPSC24500
 */

package hw11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Test {

	static Scanner kb;
	
	public static void main(String[] args) {
		kb = new Scanner(System.in);
		while(true) {
			mainMenu();
		}
	}
	
	private static void mainMenu() {
		//Display main menu
		System.out.println("\nWhat would you like to do?");
		System.out.println("	1. Create new file");
		System.out.println("	2. Read from file");
		System.out.print("Please enter the number of your choice, or 0 to quit: ");
		
		//Get user selection
		int selection;
		selection = kb.nextInt();
		
		//Process user selection
		switch(selection) {
		case 0:
			System.exit(0);
			
		case 1:
			//Create new file
			createNewFile();
			break;
			
		case 2:
			//Read from file
			String fileName = getFileName();
			try {
				readFile(fileName);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}
	
	public static void createNewFile() {
		String fileName = getFileName();
		String name = getName();
		String phoneNumber = getPhoneNumber();
		String dob = getDob();
		String emailAddress = getEmailAddress();
		
		Person p = new Person(name, phoneNumber, dob, emailAddress);
		
		try {
			writeToFile(p, fileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getFileName() {
		clearScannerBuffer();
		System.out.print("Enter a file name: ");
		String fileName = kb.next();
		return fileName;
	}
	
	public static String getName() {
		clearScannerBuffer();
		System.out.print("Enter a name: ");
		String name = kb.next();
		return name;
	}
	
	public static String getPhoneNumber() {
		clearScannerBuffer();
		System.out.print("Enter a phone number: ");
		String phoneNumber = kb.next();
		return phoneNumber;
	}
	
	public static String getDob() {
		clearScannerBuffer();
		System.out.print("Enter a date of birth: ");
		String dob = kb.next();
		return dob;
	}
	
	public static String getEmailAddress() {
		clearScannerBuffer();
		System.out.print("Enter an email address: ");
		String emailAddress = kb.next();
		return emailAddress;
	}

	public static void writeToFile(Person p, String fileName) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName + ".bin"));
		objectOutputStream.writeObject(p);
		objectOutputStream.close();
	}
	
	public static void readFile(String fileName) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName + ".bin"));
		Person name = (Person) objectInputStream.readObject();
		System.out.println(name);
		objectInputStream.close();
	}
	
	public static void clearScannerBuffer() {
		kb.nextLine();
	}
}
