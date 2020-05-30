package hw11;

import java.io.Serializable;

public class Person implements Serializable{
	private String name, phoneNumber, dateOfBirth, emailAddress;

	public Person(String name, String phoneNumber, String dateOfBirth, String emailAddress) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth
				+ ", emailAddress=" + emailAddress + "]";
	}
}
