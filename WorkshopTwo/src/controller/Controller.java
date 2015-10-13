package controller;

import view.Console.Event;

public class Controller {
	
	private String entry1;
	private String entry2;
	private boolean fail=true;
	private boolean fail2=true;
	private SweID checkid=new SweID();
	
	
	public boolean Dothings(view.Console a_view, model.Server a_sys){
		
		a_view.PresentInstructions();
		
		view.Console.Event e;
		
		e = a_view.getEvent();
		
		
		if(e == Event.None){
			
			return false;
		}
		
		if(e == Event.Addmember){
			
			
			
			while(fail){
				
			entry1=a_view.getName();
			if(!entry1.matches("[a-zA-Z\\s]+") || entry1.isEmpty()){
				a_view.NamingErr();
				
			}
			else
			{
				fail=false;
			}
			
			}
			
			
			while(fail2){
			
			entry2=a_view.getPersonalNumber();
			
			if(!entry2.matches("\\d{6}-\\d{4}")){
				
				
			}
			else
			{
				
				
			boolean whethercorrect=checkid.isCorrect(entry2);
			boolean girl=checkid.isFemaleNumber(entry2);
			boolean boy=checkid.isMaleNumber(entry2);
			boolean month=checkid.MonthisCorrect(entry2);
			boolean day=checkid.DayisCorrect(entry2);
			boolean lastdigit=checkid.LastdigitisCorrect(entry2);
			
			
			if(whethercorrect==true)
			{
				fail2=false;
				if(girl==true)
				{
					a_view.CorrectFemaleNumber(entry2);
					
				}
				else if(boy==true)
				{
					a_view.CorrectMaleNumber(entry2);
					
				}
				
				
			}
			else
			{
				if(month==false)
				{
					a_view.UnvalidMonth(entry2);	
					
				}
				else if(day==false)
				{
					a_view.UnvalidDay(entry2);
					
				}
				else if(lastdigit==false)
				{
					a_view.UnvalidLastDigit(entry2);
					
				}
			}
			}
			}
			a_sys.Addmember(entry1, entry2);
			a_view.AddingCompleted();
		}
		
		
		if(e == Event.Addboat){
			
			a_sys.Addboat();
			
		}
		if(e == Event.CompactList){
			
			a_sys.CompactList();
			
		}
		if(e == Event.VerboseList){
			
			a_sys.VerboseList();
			
		}
		if(e == Event.DeleteMember){
			
			a_sys.DeleteMember();
			
		}
		if(e == Event.ChangeMemberInformation){
			
			a_sys.ChangeMemberInformation();
			
		}
		if(e == Event.LookSpecificMemberInformation){
			
			a_sys.LookSpecificMemberInformation();
			
		}
		if(e == Event.DeleteBoat){
			
			a_sys.DeleteBoat();
			
		}
		if(e == Event.ChangeBoatInformation){
			
			a_sys.ChangeBoatInformation();
			
		}
		if(e == Event.Input){
			
			a_sys.Input();
			
		}
		if(e == Event.Output){
			
			a_sys.Output();
			
		}
		if(e ==Event.BackMenu){
			
		}
		
		
		a_view.BackMenu();
		
		return true;
	}
	
	
}
