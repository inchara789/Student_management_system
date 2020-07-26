package com.cruds.tcs;




import java.util.*;


public class ScoreList<T> {
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
	
	public T averageValues()
	{
		return null;
	}
    
    //Write your code
}

