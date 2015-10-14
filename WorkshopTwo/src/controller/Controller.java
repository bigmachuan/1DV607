package controller;

import java.io.IOException;

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
		a_view.Blank();
		
		if(e == Event.None){
			
			return false;
		}
		
		if(e == Event.Addmember){
			
			boolean hasBefore=true;
			
			while(hasBefore)
			{
				
			
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
				
				a_view.AddingFailed();
				
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
					a_view.AddingFailed();
					a_view.UnvalidMonth(entry2);
					
				}
				else if(day==false)
				{
					a_view.AddingFailed();
					a_view.UnvalidDay(entry2);
					
				}
				else if(lastdigit==false)
				{
					a_view.AddingFailed();
					a_view.UnvalidLastDigit(entry2);
					
				}
			}
			}
			}
			
			
			if(a_sys.Addmember(entry1, entry2)==true)
			{
				a_view.AddingCompleted();
				hasBefore=false;
			}
			else
			{
				a_view.AddingFailed();
				a_view.MemberHasBefore();
			}
			fail=true;
			fail2=true;
			
			}
			
		}
		
		
		if(e == Event.Addboat){
			
			a_view.Show(a_sys.CompactList());
			int chooseMember = 0;
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseMember();
				if(chooseMember>a_sys.getListSize())
				{
					a_view.MemberNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			a_sys.setMember(chooseMember-1);
			
			int chooseBoatType=0;
			
			a_view.chooseBoatType();
			while(fail2){
				try{
					
					chooseBoatType=Integer.parseInt(a_view.chooseBoatTypeNumber());
					if(chooseBoatType<1 ||chooseBoatType>4){
						a_view.BoatTypeNotExist();;
					}
					else
					{
						fail2=false;
					}
					
				}catch(Exception ex2){
					a_view.NotNumber();
				}
			}
			
			fail=true;
			a_sys.setBoatType(chooseBoatType-1);
			
			int setBoatLength=0;
			
			while(fail){
				try{
					
					setBoatLength=Integer.parseInt(a_view.setBoatLength());
					fail=false;
					
					
				}catch(Exception ex2){
					
					a_view.NotNumber();
					
				}
			}
			
			a_sys.setBoatLength(setBoatLength);
			
			if(a_sys.Addboat()==true){
				a_view.AddingCompleted();
			}
			else
			{
				a_view.AddingFailed();
			}
			fail=true;
			fail2=true;
			
		}
		if(e == Event.CompactList){
			
			a_view.Show(a_sys.CompactList());
			
		}
		if(e == Event.VerboseList){
			
			a_view.Show(a_sys.VerboseList());
			
		}
		if(e == Event.DeleteMember){
			
			a_view.Show(a_sys.CompactList());
			int chooseMember = 0;
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseMember();
				if(chooseMember>a_sys.getListSize())
				{
					a_view.MemberNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			a_sys.setMember(chooseMember-1);
			
			if(a_sys.DeleteMember()==true)
			{
				a_view.DeleteComplete();
			}
			else
			{
				a_view.DeleteFailed();
			}
			
			
		}
		
		
		if(e == Event.ChangeMemberInformation){
			
			
			
			a_view.Show(a_sys.CompactList());
			int chooseMember = 0;
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseMember();
				if(chooseMember>a_sys.getListSize())
				{
					a_view.MemberNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			a_sys.setMember(chooseMember-1);
			a_view.jmp();
			fail=true;
			entry1=null;
			entry2=null;
			
            boolean hasBefore=true;
			
			while(hasBefore)
			{
			
			while(fail){
				
				entry1=a_view.getName();
				if(!entry1.matches("[a-zA-Z\\s]+")){
					a_view.NamingErr();
					
				}
				else if(entry1.isEmpty())
				{
					
					fail=false;
				}
				else
				{
					fail=false;
				}
				
				}
			
			while(fail2){
				
				entry2=a_view.getPersonalNumber();
				
				if(!entry2.matches("\\d{6}-\\d{4}")){
					
					a_view.AddingFailed();
					
				}
				else if(entry2.isEmpty())
				{
					fail2=false;
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
						a_view.AddingFailed();
						a_view.UnvalidMonth(entry2);
						
					}
					else if(day==false)
					{
						a_view.AddingFailed();
						a_view.UnvalidDay(entry2);
						
					}
					else if(lastdigit==false)
					{
						a_view.AddingFailed();
						a_view.UnvalidLastDigit(entry2);
						
					}
				}
				}
				}
				
			if(a_sys.ChangeMemberInformation(entry1, entry2)==true)
			{
				a_view.ChangeCompleted();
				hasBefore=false;
			}
			else
			{
				a_view.ChangeFailed();
				a_view.MemberHasBefore();
			}
			fail=true;
			fail2=true;
			
			}
			
		}
		if(e == Event.LookSpecificMemberInformation){
			
			a_view.Show(a_sys.CompactList());
			int chooseMember = 0;
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseMember();
				if(chooseMember>a_sys.getListSize())
				{
					a_view.MemberNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			a_sys.setMember(chooseMember-1);
			
			a_view.Show(a_sys.LookSpecificMemberInformation());
			fail=true;
			
		}
		if(e == Event.DeleteBoat){
			
			a_view.Show(a_sys.CompactList());
			int chooseMember = 0;
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseMember();
				if(chooseMember>a_sys.getListSize())
				{
					a_view.MemberNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			fail=true;
			a_sys.setMember(chooseMember-1);
			a_view.Show(a_sys.LookSpecificMemberInformation());
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseBoat();
				if(chooseMember>a_sys.getthisMembersBoatSize())
				{
					a_view.BoatNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			fail=true;
			a_sys.setBoat(chooseMember);
			
			if(a_sys.DeleteBoat())
			{
				a_view.DeleteComplete();
			}
			else
			{
				a_view.DeleteFailed();
			}
			
			
		}
		if(e == Event.ChangeBoatInformation){
			
			a_view.Show(a_sys.CompactList());
			int chooseMember = 0;
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseMember();
				if(chooseMember>a_sys.getListSize())
				{
					a_view.MemberNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			a_sys.setMember(chooseMember-1);
			
			a_view.Show(a_sys.LookSpecificMemberInformation());
			fail=true;
			
		}
		if(e == Event.DeleteBoat){
			
			a_view.Show(a_sys.CompactList());
			int chooseMember = 0;
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseMember();
				if(chooseMember>a_sys.getListSize())
				{
					a_view.MemberNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			fail=true;
			a_sys.setMember(chooseMember-1);
			a_view.Show(a_sys.LookSpecificMemberInformation());
			
			while(fail)
			{
			try{
			
				chooseMember=a_view.chooseBoat();
				if(chooseMember>a_sys.getthisMembersBoatSize())
				{
					a_view.BoatNotExist();
				}
				else
				{
					fail=false;
				}
			}catch(Exception ex){
				a_view.NotNumber();
			}
			}
			fail=true;
			a_sys.setBoat(chooseMember);
			
            int chooseBoatType=0;
			a_view.jmp();
			a_view.chooseBoatType();
			while(fail2){
				try{
					if(a_view.chooseBoatTypeNumber()==null){
						chooseBoatType=5;
						fail2=false;
					}
					else{
					
					chooseBoatType=Integer.parseInt(a_view.chooseBoatTypeNumber());
					if(chooseBoatType<1 ||chooseBoatType>4){
						a_view.BoatTypeNotExist();;
					}
					else
					{
						fail2=false;
					}
					}
				}catch(Exception ex2){
					a_view.NotNumber();
				}
			}
			
			fail=true;
			a_sys.setBoatType(chooseBoatType-1);
			
			int setBoatLength=0;
			
			while(fail){
				try{
					if(a_view.setBoatLength()==null){
						setBoatLength=-1;
						fail=false;
					}
					else{
					
					setBoatLength=Integer.parseInt(a_view.setBoatLength());
					fail=false;
					}
					
				}catch(Exception ex2){
					
					a_view.NotNumber();
					
				}
			}
			
			a_sys.setBoatLength(setBoatLength);
			
			
			
			if(a_sys.ChangeBoatInformation()==true){
				a_view.ChangeCompleted();
			}
			else
			{
				a_view.ChangeFailed();
			}
			fail=true;
			fail2=true;
			
		}
		if(e == Event.Input){
			
			try {
				a_sys.Input();
				a_view.Show("Input Completed");
			} catch (IOException e1) {
				
				a_view.errshow("Input Failed");
			}
			
			
		}
		if(e == Event.Output){
			
			try {
				a_sys.Output();
				a_view.Show("Output Completed");
			} catch (IOException e1) {
				
				a_view.errshow("Output Failed");
			}
			
		}
		if(e ==Event.BackMenu){
			
		}
		
		
		a_view.BackMenu();
		
		return true;
	}
	
	
}
