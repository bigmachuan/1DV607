package view;

import java.util.Scanner;

public class Console{
	
	private Scanner input=new Scanner(System.in);
	
	public enum Event{
		
		None,
		Addmember,
		Addboat,
		CompactList,
		VerboseList,
		DeleteMember,
		ChangeMemberInformation,
		LookSpecificMemberInformation,
		DeleteBoat,
		ChangeBoatInformation,
		Input,
		Output,
		BackMenu
		
		
	}
	
	
	public void PresentInstructions(){
		
		System.out.println();
		
		
		System.out.println("Welcome to The happy pirate");
		System.out.println("Please type in what you want to do");
		System.out.println("Here are some options: \n1.Addmember \n2.Addboat "
				+ "\n3.CompactList \n4.VerboseList \n5.DeleteMember "
				+ "\n6.ChangeMemberInformation \n7.LookSpecificMemberInformation "
				+ "\n8.DeleteBoat \n9.ChangeBoatInformation \n10.Input \n11.Output"
				+ "\n12.Quit"
				+ "\nPlease type in the Operation Number you want to do");
		
		
	}
	
	
	
	public Event getEvent(){
		
		try{
		
		int number= input.nextInt();
		
		if(number==1){
			
			return Event.Addmember;
		}
		if(number==2){
			
			return Event.Addboat;
			
		}
		if(number==3){
			
			return Event.CompactList;
		}
		if(number==4){
			
			return Event.VerboseList;
		}
		if(number==5){
			
			return Event.DeleteMember;
		}
		if(number==6){
			
			return Event.ChangeMemberInformation;
			
		}
		if(number==7){
			
			return Event.LookSpecificMemberInformation;
			
		}
		if(number==8){
			
			
			return Event.DeleteBoat;
			
		}
		if(number==9){
			
			return Event.ChangeBoatInformation;
		}
		if(number==10){
			
			return Event.Input;
		}
		if(number==11){
			
			return Event.Output;
		}
		
        if(number==12){
			
			return Event.None;
		}
		
		}catch(Exception e){
			
			System.err.println("Please type in a right number");
			
		}
		return Event.BackMenu;
		
	}
	
	
	public void BackMenu(){
		
		System.out.println("Press enter to go back to main menu");
		input.nextLine();
		input.nextLine();
	}
	
	
	public String getName(){
		
        System.out.println("Please type in member's name: ");
        input.nextLine();
		return input.nextLine();
		
	}
	
	public String getPersonalNumber(){
		
		System.out.println("Please type in an ID number as the single type \"YYMMDD‐NNNN\": ");
		String getID=input.nextLine();
		return getID;
		
	}
	
	public void CorrectFemaleNumber(String getID){
		System.out.println("\n"+getID+" is a correct female number");
	}
	
	public void CorrectMaleNumber(String getID){
		System.out.println("\n"+getID+" is a correct male number");
	}
	
	public void UnvalidMonth(String getID){
		System.err.println("Adding PersonalNumber failed");
	    System.out.println(getID+" is not correct number (unvalid month)");	
	}
	
	public void UnvalidDay(String getID){
		System.err.println("Adding PersonalNumber failed");
		System.out.println(getID+" is not correct number (unvalid day)");
	}
	
	public void UnvalidLastDigit(String getID){
		System.err.println("Adding PersonalNumber failed");
		System.out.println(getID+" is not correct number (unvalid last digit)");
	}
	
	public void AddingCompleted(){
		System.out.println("Adding completed");
	}
	
	
	public void NamingErr(){
		
		System.out.println("Please type in a right spelling name");
		
	}
	
	
	
	
	
}
