package com.cruds.tcs;

public class StudentClass {
	
    public String getQuery(String studentData,String query){
        
    	String[] tokens = query.split(",");

    	String choice = tokens[0];
    	
    	switch (choice) {
		case "1":
		{
			StudentList<String> namelist = new StudentList<>();
			String[] names = studentData.split(" ");
			
			for(String s : names)
			{
				namelist.addElement(s);
			}
			return namelist.beginsWith(tokens[1]);
		}
		case "2":
		{
			StudentList<String> namelist = new StudentList<>();
			String[] names = studentData.split(" ");
			
			for(String s : names)
			{
				namelist.addElement(s);
			}
			String[] blood = tokens[1].split(" ");
			for(String s : blood)
			{
				if(tokens[2].contentEquals(s))
				   namelist.addElement(s);
			}
			
			return namelist.bloodGroupOf(tokens[2]);
		}
		case "3":
		{
			StudentList<String> scorelist = new StudentList<>();
			String[] marks = studentData.split(" ");
			
			
			for(String s : marks)
			{
					
				   scorelist.addElement(s);
			}
			return scorelist.thresholdScore(tokens[1]);
		}
		
		
			
		default:
			break;
		}
    	
		return null;
		
    }
    
}
