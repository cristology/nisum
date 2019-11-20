package com.example.demo.model;

public class PersonaModel {
    
    private String id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String hairColour;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHairColour() {
		return hairColour;
	}
	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}
	
	@Override
	public String toString() {
		return "PersonaModel [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", hairColour=" + hairColour + "]";
	}
    
      
      
    
}