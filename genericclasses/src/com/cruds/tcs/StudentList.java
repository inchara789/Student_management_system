package com.cruds.tcs;

import java.util.*;

public class StudentList<T> extends ArrayList<T> {
    
	private List<T> list = new ArrayList<T>();
	
	public boolean addElement(T t)
	{
		return list.add(t);
	}
	
	public boolean removeElement(T t)
	{
		return list.remove(t);
	}
	
	public T getElement(int index)
	{
		return list.get(index);
	}
   
	public String beginsWith(String s)
	{
		String result = "";
		
		for(T t : list)
		{
			String name = (String)t;
			if(name.startsWith(s) || name.startsWith(s.toUpperCase()))
			{
				result += name + "\n";
			}
			
		}
		return result;
	}

	public String bloodGroupOf(String s)
	{
		String result = "";
		
		for(T t : list)
		{
			String name = (String)t;
			
			{
					result += name + "\n";
				}
			
		}
		return  result;
	}
    
	public String thresholdScore(String s)
	{
		int count=0;
		for(T t : list)
		{
			int x=Integer.parseInt((String) t);
			if(x>= (Integer.parseInt(s)))
			count++;
		}
		return String.valueOf(count);	
	}
    
}

	
	
	
	
	
	

