package model.ListRule;

import java.util.ArrayList;

import model.Member;

public interface IListRule {
	
	public ArrayList<Member> List(ArrayList<Member> List);
	public boolean SetParameters(String parameters);

}
