package com.cruds.io;

import java.io.Serializable;

import com.cruds.exception.SMSException;

public class StudentDb implements Serializable {
	private int rollno;
	private String name;
	
	
	
	public StudentDb  (int rollno, String name) throws SMSException {
		
		if(name.equalsIgnoreCase("") || name.equals(null))
    	{
    		throw new SMSException("name cannot be null");
    	}
    	if(rollno<0 )
    	{
    		throw new SMSException("rollnum cant be negative"+rollno);
    	}
		this.rollno = rollno;
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentDb [rollno=" + rollno + ", name=" + name + "]";
	}
	

}
