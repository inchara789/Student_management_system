package com.sms.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSms {

	public static void main(String[] args) {
		Sms[] B=new Sms[25];
		List<Sms> list=new ArrayList<>();

		int pos=0;
		String name;
		int rollno; 
		String choice= "";
		Scanner scan=new Scanner(System.in);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sms.ser"));)
		{
			 list=(List<Sms>) ois.readObject();
			 for(Sms s:list)
				{
					System.out.println(s);
				}

		} catch (FileNotFoundException e1) {
			System.out.println("First Run..");
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		do {
			System.out.println("choose \n 1 for add Student \n 2 for search Student \n 3 for list all names \n 4 for delete a student\n 5 for exit");
			choice=scan.nextLine();
			System.out.println("selected choice is "+ choice);
			switch(choice)
			{
			case "1":
			{
				while(pos<B.length)
			{
				System.out.println("adding a student");
			    System.out.println("enter student name: ");
				name=scan.nextLine();
				System.out.println("enter roll number: ");
				rollno=scan.nextInt();
				scan.nextLine();
				Sms bd = new Sms(rollno, name);
				B[pos] = bd;
				list.add(bd);
				pos++;
				int rows=0;
				try(Connection conn=ConnectionDB.getConnection())
				{
				
					String sql="insert into Sms (rollno,name) values(?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
						ps.setInt(1, list.get(pos).getRollno());
						ps.setString(2, list.get(pos).getName());
						rows=ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
				break;
				
			}
			
			case "2":
			{
				System.out.println("enter the student roll no to be searched");
				int searchno=scan.nextInt();
				boolean flag=false;
				String sql="select rollno,name from student where rollno=?";
				Sms s=null;
				try(Connection conn=ConnectionDB.getConnection())
				{
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, searchno);
					ResultSet rs=ps.executeQuery();
					if(rs!=null && rs.next())
					{
						s=new Sms(rs.getInt(1),rs.getString(2));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				for(int i=0; i < list.size(); i++)
				{
					if(searchno == list.get(i).getRollno());
					  flag=true;
				}
				if(flag)
					System.out.println("found");
				else
					System.out.println("not found");
				
				break;
			}
			
			case "3":
			{
				System.out.println("listing all the elements:");
				for(Sms s:list)
				{
					System.out.println(s);
				}
				String sql="select rollno,name from student";
				Sms s=null;
				List<Sms> ls=new ArrayList<>();
				try(Connection conn=ConnectionDB.getConnection())
				{
					PreparedStatement ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs != null && rs.next())
					{
						s=new Sms(rs.getInt(1),rs.getString(2));
						ls.add(s);
					}
					for(Sms p:ls)
					{
						System.out.println(p);
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			}
			case "4":
			{
				System.out.println("enter the student rollnum to be deleted");
				int delroll=scan.nextInt();
				for(int i=0; i < list.size(); i++)
				{
					if(delroll == list.get(i).getRollno());
					   list.remove(i);
				}
			
				int rows=0;
				try(Connection conn=ConnectionDB.getConnection())
				{
					String sql="delete from Sms where rollno=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, delroll);
					rows=ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("student deleted");
				break;
			}
			
			case "5":
			{
				System.out.println("exiting..");
				try(ObjectOutputStream is=new ObjectOutputStream(new FileOutputStream("sms.ser"))){
					
					 ((ObjectOutput) is).writeObject(list);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
				
			}
			
			default:{ 
				System.out.println("invalid choice..");
			break;
			}
			}
	

			
		} while (!choice.equals("5"));
		scan.close();
		

	}

	}

