package model.ListRule;

import java.util.ArrayList;

import model.Member;

public class NameList implements IListRule{
	
	private String name;

	
	public ArrayList<Member> List(ArrayList<Member> List) {
		
		int length=name.length();
		
		for(int i=0;i<List.size();i++)
		{
			if(!name.equals(List.get(i).getName().substring(0, length-1)))
			{
				List.remove(i);
			}
		}
		
		return List;
	}

	
	public boolean SetParameters(String parameters) {
		
		name=parameters;
		return true;
	}

}
