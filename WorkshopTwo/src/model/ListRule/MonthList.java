package model.ListRule;

import java.util.ArrayList;

import model.Member;

public class MonthList implements IListRule{
	
	private int month;

	
	public ArrayList<Member> List(ArrayList<Member> List) {
		
		for(int i=0;i<List.size();i++)
		{
			
			if(month!=Integer.parseInt(List.get(i).getPersonalnumber().substring(4, 5)))
			{
				List.remove(i);
			}
		}
		
		return List;
	}

	
	public boolean SetParameters(String parameters) {
		try
		{
			month=Integer.parseInt(parameters);
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	
	}

}
