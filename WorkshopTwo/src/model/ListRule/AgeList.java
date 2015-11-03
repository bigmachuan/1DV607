package model.ListRule;

import java.util.ArrayList;

import model.Member;

public class AgeList implements IListRule{
	
	private int age;

	
	public ArrayList<Member> List(ArrayList<Member> List) {
		
		int year=2015-age;
		
		
		for(int i=0;i<List.size();i++)
		{
			
			if(year!=Integer.parseInt(List.get(i).getPersonalnumber().substring(0, 3)))
			{
				List.remove(i);
			}
		}
		
		return List;
		
	}

	
	public boolean SetParameters(String parameters) {
		
		try
		{
			age=Integer.parseInt(parameters);
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

}
