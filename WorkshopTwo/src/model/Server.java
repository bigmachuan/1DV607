package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
	
	private Boat m_boat;
	private Member m_member;
	private int setMember;
	private int setBoat;
	private BoatType setBoatType;
	private int setBoatLength;
	private String setMemberName;
	private String setMemberPersonalNumber;
	private int TypenotChange=0;
	
	public int getthisMembersBoatSize(){
		return list.get(setMember).boats.size();
	}
	
	public Boat getM_boat() {
		return m_boat;
	}

	public void setM_boat(Boat m_boat) {
		this.m_boat = m_boat;
	}

	public Member getM_member() {
		return m_member;
	}

	public void setM_member(Member m_member) {
		this.m_member = m_member;
	}

	public int getSetMember() {
		return setMember;
	}

	public void setSetMember(int setMember) {
		this.setMember = setMember;
	}

	public int getSetBoat() {
		return setBoat;
	}

	public void setSetBoat(int setBoat) {
		this.setBoat = setBoat;
	}

	public BoatType getSetBoatType() {
		return setBoatType;
	}

	public void setSetBoatType(BoatType setBoatType) {
		this.setBoatType = setBoatType;
	}

	public int getSetBoatLength() {
		return setBoatLength;
	}

	public void setSetBoatLength(int setBoatLength) {
		this.setBoatLength = setBoatLength;
	}

	public String getSetMemberName() {
		return setMemberName;
	}

	public void setSetMemberName(String setMemberName) {
		this.setMemberName = setMemberName;
	}

	public String getSetMemberPersonalNumber() {
		return setMemberPersonalNumber;
	}

	public void setSetMemberPersonalNumber(String setMemberPersonalNumber) {
		this.setMemberPersonalNumber = setMemberPersonalNumber;
	}

	public ArrayList<Member> getList() {
		return list;
	}

	public void setList(ArrayList<Member> list) {
		this.list = list;
	}
	private ArrayList<Member> list;
	
	public Server(){
		
		list=new ArrayList<Member>();
		
	}
	
	public ArrayList<Member> getmembers(){
		
		return list;
	}
	
	public int getListSize(){
		return list.size();
	}
	
	public void setMember(int number){
		
		this.setMember=number;
	}
	
	public void setBoatType(int setBoatType){
		
		if(setBoatType==0){
			this.setBoatType=BoatType.Sailboat;
		}
		if(setBoatType==1){
			this.setBoatType=BoatType.Motorsailer;
		}
		if(setBoatType==2){
			this.setBoatType=BoatType.Canoe;
		}
		if(setBoatType==3){
			this.setBoatType=BoatType.Other;
		}
		if(setBoatType==4){
			TypenotChange=1;
		}
		
	}
	public void setBoat(int setBoat){
		this.setBoat=setBoat;
	}
	
	public void setBoatLength(int setBoatLength){
		this.setBoatLength=setBoatLength;
	}
	
	
	
	public boolean Addmember(String Name, String PersonalNumber){
		
		m_member = new Member();
		m_member.setName(Name);
		m_member.setPersonalnumber(PersonalNumber);
		
		boolean hasBefore = false;
		
		if(list.size()==0)
		{
			hasBefore=false;
		}
		else
		{
		for(int i=0;i<list.size();i++){
			
			if(m_member.compareTo(list.get(i))==0)
			{
				hasBefore=true;
			}
		}
		}
		
		if(hasBefore==false){
			list.add(m_member);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean Addboat(){
		
		m_boat = new Boat();
		m_boat.setType(setBoatType);
		m_boat.setLength(setBoatLength);
		
		list.get(setMember).boats.add(m_boat);
		return true;
		
	}
	
	
	public String CompactList(){
		
		String compactlist = "";
		
		for(int i=0;i<list.size();i++)
		{
			compactlist=compactlist+"\n"+((i+1)+"."+list.get(i).getName()+" "+"ID: "+list.get(i).getId()+" "+list.get(i).boats.size()+" "+"boat(s)");
			
		}
		
		return compactlist;
	}
	
	public String VerboseList(){
		
		String VerboseList = "";
		
		for(int i=0;i<list.size();i++)
		{
			VerboseList=VerboseList+"\n"+(list.get(i).getName()+" "+"Personal Number: "+list.get(i).getPersonalnumber()+" "+"ID: "+list.get(i).getId());
			VerboseList=VerboseList+"\n"+("Boats:");
			for(int j=0;j<list.get(i).boats.size();j++)
			{
				VerboseList=VerboseList+"\n"+((j+1)+". "+list.get(i).boats.get(j).getType()+" "+list.get(i).boats.get(j).getLength()+"m "+"ID: "+list.get(i).boats.get(j).getId());
			}
			
		}
		
		return VerboseList;
		
		
	}
	
	public boolean DeleteMember(){
		
		list.remove(setMember);
		return true;
		
	}
	
	public boolean ChangeMemberInformation(String name, String number){
		
		Member change=list.get(setMember);
		boolean hasBefore=false;
		if(!name.equals("")){
			change.setName(name);
		}
		if(!number.equals("")){
			
			change.setPersonalnumber(number);
			
			 for(int i=0;i<list.size();i++){
			
			if(change.compareTo(list.get(i))==0)
			{
				hasBefore=true;
			}
		}
		}
		
        if(hasBefore==false){
        	list.set(setMember, change);
        	return true;
        }
        else
        {
        	return false;
        }
	}
	
	public String LookSpecificMemberInformation(){
		
		
		 Member choose = list.get(setMember);
		 String show="";
		 show=show+(choose.getName()+" "+choose.getPersonalnumber()+" "+choose.getId());
		 show=show+("\n"+"Boats:");
		 
		 for(int i=0;i<choose.boats.size();i++)
		 {
			 show=show+("\n"+(i+1)+". "+choose.boats.get(i).getType()+" "+choose.boats.get(i).getLength()+"m");
		 }
		 
		 return show;
		 
	}
	
	public boolean DeleteBoat(){
		System.out.println(list.get(setMember).getName());
		System.out.println(setBoat);
		list.get(setMember).boats.remove(setBoat);
		return true;
		
		
	}
	
	public boolean ChangeBoatInformation(){
		
		Member change=list.get(setMember);
		Boat changeinfo=change.boats.get(setBoat);
		
		if(TypenotChange==0)
		{
			changeinfo.setType(setBoatType);
		}
		if(setBoatLength!=-1)
		{
			changeinfo.setLength(setBoatLength);
		}
		
		change.boats.set(setBoat, changeinfo);
		list.set(setMember, change);
		return true;
		 
	}
	
	private enum LoadStatus
	{
		Member,
		Boat
	}
	
	
	private String m_fileName= "members.txt";
	
	
	public boolean Output() throws IOException{
		
		PrintWriter memberWriter = new PrintWriter(m_fileName);
		memberWriter.write("Members"+"\n");
		for(int i=0;i<list.size();i++)
		{
			memberWriter.write(list.get(i).getName()+";"+list.get(i).getPersonalnumber()+";"+list.get(i).getId()+";"+list.get(i).boats.size()+"\n");
		}
		memberWriter.write("Boats"+"\n");
		
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.get(i).boats.size();j++)
			{
				memberWriter.write(list.get(i).boats.get(j).getLength()+";"+list.get(i).boats.get(j).getType()+";"+list.get(i).boats.get(j).getId()+";"+list.get(i).getPersonalnumber()+"\n");
			}
		
		
		}
		memberWriter.close();
		return true;
	}
	
	
	
	public boolean Input() throws IOException{
		
		LoadStatus stat = LoadStatus.Member;
		list=new ArrayList<Member>();
		
		FileReader fr=new FileReader(m_fileName);
		BufferedReader br=new BufferedReader(fr);
		
		StringBuilder result = new StringBuilder();
		String str;
		while((str=br.readLine())!=null)
        {
			result.append(str+"\n");
			
        }
		br.close();
		Scanner scan=new Scanner(result.toString());
		
		
		while(scan.hasNextLine())
        {
			
			String line=scan.nextLine();
			
			if(line.equals("Members"))
			{
				stat= LoadStatus.Member;
			}
			else if(line.equals("Boats"))
			{
				stat= LoadStatus.Boat;
			}
			else
			{
				if(stat==LoadStatus.Member)
				{
					if(!line.equals("Members")){
						
					String[] member=line.split(";");
					String name = member[0];
					String personalNumber=member[1];
					String id=member[2];
					
					list.add(new Member(name,personalNumber,id));
					}
				}
				else if(stat == LoadStatus.Boat)
				{
					if(!line.equals("Boats")){
						
					String[] boat = line.split(";");
					
					for(int i=0;i<list.size();i++){
						
						if(list.get(i).getPersonalnumber().equals(boat[3]))
						{
							int length = Integer.parseInt(boat[0]);
							String boattype=boat[1];
							String boatid=boat[2];
							
							Member change=list.get(i);
							Boat changeinfo = new Boat(boattype,length,boatid);
							
							change.boats.add(changeinfo);
							list.set(i, change);
							
							
						}
						
					}
					
				}
			}
				
				
		}
	      }
		scan.close();
	    return true;
	}
	
	
	

}
