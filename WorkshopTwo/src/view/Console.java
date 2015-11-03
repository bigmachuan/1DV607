package view;

import java.util.Scanner;

public class Console{
	
	private Scanner input;
	
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
		BackMenu,
		Visitor,
		Administrator
		
		
	}
	
	
	public void PresentInstructions(){
		
		System.out.println();
		//input=new Scanner(System.in);
		
		System.out.println("Welcome to The happy pirate");
		System.out.println("Please type in what you want to do");
		System.out.println("Here are some options: \n1.Addmember \n2.Addboat "
				+ "\n3.CompactList \n4.VerboseList \n5.DeleteMember "
				+ "\n6.ChangeMemberInformation \n7.LookSpecificMemberInformation "
				+ "\n8.DeleteBoat \n9.ChangeBoatInformation \n10.Input \n11.Output"
				+ "\n12.Quit"
				+ "\nPlease type in the Operation Number you want to do");
		
		
	}
	
	public void Authentication(){
		
		System.out.println();
		input=new Scanner(System.in);
		
		System.out.println("Welcome to The happy pirate");
		System.out.println("You are a:");
		System.out.println("1.Visitor\n2.Administrator");
		
		
	}
	
	public Event getAuthentication(){
		
		try{
			
			int number= input.nextInt();
			
			if(number==1)
			{
				return Event.Visitor;
			}
			if(number==2)
			{
				return Event.Administrator;
			}
			
			
        }catch(Exception e){
			
			System.err.println("Please type in a right number");
			
		}
		input.nextLine();
		return Event.BackMenu;
			
		
	}
	
	public String getAdministratorUserName(){
		input.nextLine();
		System.out.println("Please Type in Administrator User Name:");
		return input.nextLine();
		
	}
	
	public String getAdministratorUserPassword(){
		System.out.println("Please Type in Administrator User Password:");
		return input.nextLine();
		
	}
	
	public void NotAdministrator(){
		
		System.err.println("Wrong Administrator Name or Password.");
		
	}
	
	public void PresentInstructionsForVistor(){
		
		System.out.println();
		//input=new Scanner(System.in);
		
		System.out.println("Welcome to The happy pirate");
		System.out.println("Please type in what you want to do");
		System.out.println("Here are some options:  "
				+ "\n1.CompactList \n2.VerboseList"
				+ "\n3.LookSpecificMemberInformation "
				+ "\n4.Quit"
				+ "\nPlease type in the Operation Number you want to do");
		
	}
	
	public Event getEventForVistor(){
		
		try{
			
			int number= input.nextInt();
			
			if(number==1)
			{
				return Event.CompactList;
			}
			if(number==2)
			{
				return Event.VerboseList;
			}
			if(number==3)
			{
				return Event.LookSpecificMemberInformation;
			}
			if(number==4)
			{
				return Event.None;
			}
			
			
			
        }catch(Exception e){
			
			System.err.println("Please type in a right number");
			
		}
		input.nextLine();
		return Event.BackMenu;
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
		input.nextLine();
		return Event.BackMenu;
		
	}
	
	
	public void BackMenu(){
		
		System.out.println("Press enter to go back to main menu");
		input.nextLine();
		
	}
	
	
	public void Blank(){
		input.nextLine();
	}
	
	public String getName(){
		
        System.out.println("Please type in member's name: ");
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
	
	public void AddingFailed(){
		System.err.println("Adding failed");
	}
	
	
	public void NamingErr(){
		System.err.println("Please type in a right spelling name");
	}
	
	public void MemberHasBefore(){
		System.err.println("This Member's Personal Number has added before");
	}
	
	public void Show(String list){
		System.err.println(list);
	}
	
	public int chooseMember(){
		System.out.println("Please type in the Number of Member: ");
		return input.nextInt();
	}
	
	public void MemberNotExist(){
		System.err.println("Please choose a Member which list above");
	}
	
	public void NotNumber(){
		System.err.println("Please type in a number");
	}
	
	public void chooseBoatType(){
		System.out.println("Please choose a type for Boat:"
				+ "\n1.Sailboat"
				+ "\n2.Motorsailer"
				+ "\n3.Canoe"
				+ "\n4.Other");
		input.nextLine();
		
	}
	public void BoatTypeNotExist(){
		System.err.println("Please choose a boat type which list above");
	}
	public String chooseBoatTypeNumber(){
		System.out.println("Please type in the Number of Boat's Type: ");
		return input.nextLine();
	}
	
	public String setBoatLength(){
		System.out.println("Please type in this boat's length(meter): ");
		return input.nextLine();
	}
	
	public void DeleteComplete(){
		System.out.println("Delete Completed");
	}
	
	public void DeleteFailed(){
		System.err.println("Delete Failed");
	}
	
	public void jmp(){
		System.out.println("You can press enter(Don't type in anything) if you don't want change this parameter");
	}
	
	public void ChangeCompleted(){
		System.out.println("Change Completed");
	}
	
	public void ChangeFailed(){
		System.err.println("Change Failed");
	}
	
	public int chooseBoat(){
		System.out.println("Please type in the Number of Boat: ");
		return input.nextInt();
	}
		
	public void BoatNotExist(){
		System.err.println("Please choose a Boat which list above");
	}
	
	public void errshow(String err){
		System.err.println(err);
	}
	
}
